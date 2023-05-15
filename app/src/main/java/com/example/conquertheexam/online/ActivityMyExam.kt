package com.example.conquertheexam.online

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conquertheexam.R
import com.example.conquertheexam.online.adapter.CustomAdapterListDataExam
import com.example.conquertheexam.online.adapter.EventClickInterFace
import com.example.conquertheexam.online.model.DataAdapterExam
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import java.io.File
import java.io.FileOutputStream


// import create file excel
import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.content.ContextCompat
import com.itextpdf.text.Document
import com.itextpdf.text.Font
import com.itextpdf.text.pdf.BaseFont
import java.io.OutputStream

class ActivityMyExam : AppCompatActivity() {
    private lateinit var currentUser: FirebaseUser
    private val STORAGE_PERMISSION_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_exam)
        DataAdapter()
    }

    // adapter data exam
    fun DataAdapter() {
        currentUser = FirebaseAuth.getInstance().currentUser!!
        val rcv = findViewById<RecyclerView>(R.id.rcvListMyExam)
        val list: MutableList<DataAdapterExam> = mutableListOf()
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
                    val nameClient = currentUser.email

                    Log.e("nameee", dataScore.toString())
                    id = document.id
                    if (nameClient == creator) {
                        list.add(
                            DataAdapterExam(
                                id,
                                name!!.toString(),
                                time!!.toLong(),
                                creator!!.toString(),
                                password
                            )
                        )
                    }
                    val adapter = CustomAdapterListDataExam(list, object : EventClickInterFace {
                        override fun OnClickItem(pos: Int) {
                            // create dialog
                            val alertDialogBuilder = AlertDialog.Builder(this@ActivityMyExam)
                            alertDialogBuilder.setTitle("Tùy Chọn")
                            alertDialogBuilder.setPositiveButton("Xóa Đề Thi") { dialog, _ ->
                                // Xử lý khi người dùng bấm nút xóa đề thi
                                val deleteDialog = AlertDialog.Builder(this@ActivityMyExam)
                                deleteDialog.setTitle("Thông Báo")
                                deleteDialog.setMessage("Bạn có chắc chắn muốn xóa đề thi này?")
                                deleteDialog.setPositiveButton("Xác nhận") { dialog, _ ->
                                    val collectionExam =
                                        db.collection("exams").document(list[pos].id.toString())
                                    collectionExam.delete()
                                        .addOnSuccessListener {
                                            list.removeAt(pos)
                                            rcv.adapter!!.notifyDataSetChanged()
                                            Toast.makeText(this@ActivityMyExam,"Xóa thành công!", Toast.LENGTH_SHORT).show()
                                        }
                                        .addOnFailureListener { exception ->
                                            // Xử lý khi xảy ra lỗi
                                        }
                                }
                                deleteDialog.setNegativeButton("Hủy") { dialog, _ ->
                                    // Xử lý khi người dùng bấm nút Hủy
                                    dialog.dismiss() // Đóng AlertDialog
                                }
                                deleteDialog.show() // Hiển thị AlertDialog

                            }
                            alertDialogBuilder.setNegativeButton("Bảng Điểm") { dialog, _ ->
                                //get data from database
                                val collectionExam =
                                    db.collection("exams").document(list[pos].id.toString())
                                collectionExam.get()
                                    .addOnSuccessListener { document ->
                                        if (document != null && document.exists()) {
                                            val data = document.data

                                            val scoresData = data?.getValue("scores").toString()
                                            val parts = scoresData.split(",")
                                            var fileContent = "" // Nội dung tệp
                                            var i :  Int = 1
                                            for (part in parts) {
                                                var remove1 = part.replace("{", "")
                                                var remove2 = remove1.replace("}", "")
                                                var remove3 = remove2.replace("=", " | Score: ")
                                                fileContent += "$i. " + remove3 +"\n"
                                                i++
                                            }
                                            // create file
                                            checkStoragePermission()
                                            if (isStoragePermissionGranted()) {
                                                val document = Document()
                                                val fileName = list[pos].name + "_bang_diem.pdf"
                                                val filePath = Environment.getExternalStorageDirectory().absolutePath + File.separator + fileName

                                                try {
                                                    val outputStream: OutputStream = FileOutputStream(filePath)
                                                    PdfWriter.getInstance(document, outputStream)

                                                    document.open()
                                                    document.add(Paragraph(fileContent))

                                                    document.close()
                                                    openPDFFile(filePath)

                                                    Toast.makeText(this@ActivityMyExam, "Tạo tệp PDF thành công.", Toast.LENGTH_SHORT).show()
                                                } catch (e: Exception) {
                                                    e.printStackTrace()
                                                    Toast.makeText(this@ActivityMyExam, "Lỗi khi tạo tệp PDF.", Toast.LENGTH_SHORT).show()
                                                }
                                            }

                                            //------------------


                                        } else {

                                        }
                                    }
                                    .addOnFailureListener { exception ->

                                    }

                            }
                            alertDialogBuilder.show() // Hiển thị AlertDialog


                            //--------------------------------------


                        }
                    })
                    rcv.adapter = adapter
                }


                rcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            }
            .addOnFailureListener { exception ->
                Log.w("Firestore", "Error getting documents: ", exception)
            }
    }


    private fun checkStoragePermission() {
        if (!isStoragePermissionGranted()) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                STORAGE_PERMISSION_CODE
            )
        }
    }

    private fun isStoragePermissionGranted(): Boolean {
        val result = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        return result == PackageManager.PERMISSION_GRANTED
    }
    private fun openPDFFile(filePath: String) {
        val file = File(filePath)
        val uri: Uri = Uri.fromFile(file)
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(uri, "application/pdf")
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Không tìm thấy ứng dụng xem PDF.", Toast.LENGTH_SHORT).show()
        }
    }
}