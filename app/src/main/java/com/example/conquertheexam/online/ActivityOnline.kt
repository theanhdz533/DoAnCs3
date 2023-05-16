package com.example.conquertheexam.online

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.conquertheexam.MainActivity
import com.example.conquertheexam.R
import com.example.conquertheexam.databinding.ActivityOnlineBinding
import com.example.conquertheexam.online.adapter.CustomAdapterListDataExam
import com.example.conquertheexam.online.adapter.EventClickInterFace
import com.example.conquertheexam.online.model.DataAdapterExam
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.parser.PdfTextExtractor
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.time.LocalDateTime

class ActivityOnline : AppCompatActivity() {
    private lateinit var currentUser: FirebaseUser
    private val PICK_PDF_REQUEST = 1
    private var selectedPdfUri: Uri? = null
    lateinit var list : MutableList<DataAdapterExam>


    private lateinit var binding: ActivityOnlineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online)
        binding = ActivityOnlineBinding.inflate(layoutInflater)
        binding.nav.itemIconTintList = null
        setContentView(binding.root)
        currentUser = FirebaseAuth.getInstance().currentUser!!

        binding.nav.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.addNewExam -> {
                    val intent = Intent(Intent.ACTION_GET_CONTENT)
                    intent.type = "application/pdf"
                    startActivityForResult(intent, PICK_PDF_REQUEST)

                }
                R.id.chatBot -> {
                    val intent = Intent(this, ActivityChatbot::class.java)
                    startActivity(intent)
                }
                R.id.myExam ->{
                    val intent = Intent(this, ActivityMyExam::class.java)
                    startActivity(intent)
                }
                R.id.signOut -> {
                    FirebaseAuth.getInstance().signOut()
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                }

            }
            true
        }
        // get data from nav header
        val nav = findViewById<NavigationView>(R.id.nav)
        val headerNav = nav.getHeaderView(0)
        val clientName = headerNav.findViewById<TextView>(R.id.txtName)
        val avatar = headerNav.findViewById<ImageView>(R.id.avatar)

        // set data for user
        clientName.setText(currentUser.displayName.toString())
        Glide.with(this)
            .load(currentUser.photoUrl.toString())
            .into(avatar)

        // set data for recycle view
        DataAdapter()
        search()



    }

    // display menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.open_menu, menu)
        return true
    }

    // event click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (binding.nav.isVisible == true) {
            when (item.itemId) {
                R.id.open_menu -> binding.nav.visibility = View.GONE
            }
        } else {
            when (item.itemId) {
                R.id.open_menu -> binding.nav.visibility = View.VISIBLE

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        FirebaseAuth.getInstance().signOut()
    }

    // upload file pdf
    @SuppressLint("NewApi")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            selectedPdfUri = data.data


            val storage = FirebaseStorage.getInstance()
            val name = currentUser.email.toString()
            val time = LocalDateTime.now().toString()
            val storageRef = storage.reference.child("$name" + "-$time")
            val uploadTask = storageRef.putFile(selectedPdfUri!!).addOnSuccessListener {
                storageRef.getBytes(Long.MAX_VALUE).addOnSuccessListener { bytes ->
                    val pdfReader = PdfReader(bytes)
                    val stringBuilder = StringBuilder()
                    for (i in 1..pdfReader.numberOfPages) {
                        stringBuilder.append(PdfTextExtractor.getTextFromPage(pdfReader, i))
                    }
                    pdfReader.close()
                    val pdfText = stringBuilder.toString()
                    val intent = Intent(this, ActivityExamPaper::class.java)
                    intent.putExtra("pdf", pdfText)
                    startActivity(intent)
                    storageRef.delete()


                }.addOnFailureListener { exception ->
                    // Xử lý khi có lỗi xảy ra
                }
            }


        }
    }

    // adapter data exam
    fun DataAdapter() {
        val rcv = findViewById<RecyclerView>(R.id.listDataExam)
        list= mutableListOf()
        val db = Firebase.firestore
        val collection = db.collection("exams")
        var id: String = ""
        var count: Int = 0
        collection.get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val name = document.getString("name")
                    val time = document.getLong("time")
                    val creator = document.getString("creator")
                    val password = document.getString("password")


                    val nameClient = currentUser.email

                    id = document.id
                    list.add(
                        DataAdapterExam(
                            id,
                            name!!.toString(),
                            time!!.toLong(),
                            creator!!.toString(),
                            password
                        )
                    )
                    val adapter = CustomAdapterListDataExam(list, object : EventClickInterFace {
                        override fun OnClickItem(pos: Int) {
                            val docRef = db.collection("exams").document(list[pos].id.toString())
                            docRef.get()
                                .addOnSuccessListener { document ->
                                    if (document != null && document.exists()) {
                                        var dataScore = ""
                                        val data = document.data
                                         dataScore += data?.getValue("scores")
                                        Log.e("dataScore", dataScore.toString())
                                        if (dataScore.toString().contains(nameClient.toString())) {
                                            val str = dataScore.toString()
                                            val parts =
                                                str.split(",") // Tách chuỗi str thành các phần tử dựa trên dấu phẩy ","
                                            var point: String = ""
                                            for (part in parts) {
                                                if (part.contains(nameClient.toString())) {
                                                    val index = part.indexOf('=')
                                                    point = part.substring(index + 1, index + 4)
                                                    Log.e("data point", point.toString())
                                                }
                                            }
                                            val builder = AlertDialog.Builder(this@ActivityOnline)
                                            builder.setTitle("Bạn đã làm bài thi này!")
                                            builder.setMessage("Điểm của bạn là: $point")
                                            val dialog = builder.create()
                                            dialog.show()
                                        } else {
                                            val builder = AlertDialog.Builder(this@ActivityOnline)
                                            builder.setTitle("Nhập mật khẩu của phòng thi")
                                            val input = EditText(this@ActivityOnline)
                                            builder.setView(input)
                                            builder.setPositiveButton("Xác Nhận") { dialog, which ->
                                                val textInput = input.text.toString()
                                                if (textInput == list[pos].password) {
                                                    val intent = Intent(
                                                        this@ActivityOnline,
                                                        ActivityQuestionOnline::class.java
                                                    )
                                                    intent.putExtra("id", list[pos].id)
                                                    startActivity(intent)
                                                } else {
                                                    Toast.makeText(
                                                        this@ActivityOnline,
                                                        "Mật khẩu không chính xác!",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                }

                                            }
                                            val dialog = builder.create()
                                            dialog.show()
                                        }

                                    } else {

                                    }
                                }
                                .addOnFailureListener { exception ->

                                }

                            // create dialog


                        }
                    })

                    rcv.adapter = adapter
                    rcv.adapter!!.notifyDataSetChanged()
                }


                rcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            }
            .addOnFailureListener { exception ->
                Log.w("Firestore", "Error getting documents: ", exception)
            }

    }
    fun search(){
        binding.btnSearch.setOnClickListener {
            val result: MutableList<DataAdapterExam> = mutableListOf()
            for (data in list) {
                if ((data.name!!.contains(binding.edtSearch.text.toString(), true))) {
                    result.add(data)
                }
            }
            val rcv = findViewById<RecyclerView>(R.id.listDataExam)
            val db = Firebase.firestore
            val collection = db.collection("exams")
            var id: String = ""
            var count: Int = 0
            collection.get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val name = document.getString("name")
                        val time = document.getLong("time")
                        val creator = document.getString("creator")
                        val password = document.getString("password")
                        val dataScore = document.get("scores")
                        Log.e("dataScore", dataScore.toString())
                        val nameClient = currentUser.email
                        id = document.id
                        val adapter = CustomAdapterListDataExam(result, object : EventClickInterFace {
                            override fun OnClickItem(pos: Int) {
                                val docRef = db.collection("exams").document(list[pos].id.toString())
                                docRef.get()
                                    .addOnSuccessListener { document ->
                                        if (document != null && document.exists()) {
                                            var dataScore = ""
                                            val data = document.data
                                            dataScore += data?.getValue("scores")
                                            Log.e("dataScore", dataScore.toString())
                                            if (dataScore.toString().contains(nameClient.toString())) {
                                                val str = dataScore.toString()
                                                val parts =
                                                    str.split(",") // Tách chuỗi str thành các phần tử dựa trên dấu phẩy ","
                                                var point: String = ""
                                                for (part in parts) {
                                                    if (part.contains(nameClient.toString())) {
                                                        val index = part.indexOf('=')
                                                        point = part.substring(index + 1, index + 4)
                                                        Log.e("data point", point.toString())
                                                    }
                                                }
                                                val builder = AlertDialog.Builder(this@ActivityOnline)
                                                builder.setTitle("Bạn đã làm bài thi này!")
                                                builder.setMessage("Điểm của bạn là: $point")
                                                val dialog = builder.create()
                                                dialog.show()
                                            } else {
                                                val builder = AlertDialog.Builder(this@ActivityOnline)
                                                builder.setTitle("Nhập mật khẩu của phòng thi")
                                                val input = EditText(this@ActivityOnline)
                                                builder.setView(input)
                                                builder.setPositiveButton("Xác Nhận") { dialog, which ->
                                                    val textInput = input.text.toString()
                                                    if (textInput == list[pos].password) {
                                                        val intent = Intent(
                                                            this@ActivityOnline,
                                                            ActivityQuestionOnline::class.java
                                                        )
                                                        intent.putExtra("id", list[pos].id)
                                                        startActivity(intent)
                                                    } else {
                                                        Toast.makeText(
                                                            this@ActivityOnline,
                                                            "Mật khẩu không chính xác!",
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    }

                                                }
                                                val dialog = builder.create()
                                                dialog.show()
                                            }

                                        } else {

                                        }
                                    }
                                    .addOnFailureListener { exception ->

                                    }

                                // create dialog


                            }
                        })

                        rcv.adapter = adapter
                        rcv.adapter!!.notifyDataSetChanged()
                    }


                    rcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

                }
                .addOnFailureListener { exception ->
                    Log.w("Firestore", "Error getting documents: ", exception)
                }





        }
    }
}