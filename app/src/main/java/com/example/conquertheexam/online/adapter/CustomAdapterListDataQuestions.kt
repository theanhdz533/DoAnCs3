package com.example.conquertheexam.online.adapter

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conquertheexam.R
import com.example.conquertheexam.databinding.ActivityExamPaperBinding
import com.example.conquertheexam.offline.ActivityQuestions
import com.example.conquertheexam.online.ActivityOnline
import com.example.conquertheexam.online.model.DataQuestionsOnline
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import okhttp3.internal.notify
import java.text.DecimalFormat

class CustomAdapterListDataQuestions(val list: List<DataQuestionsOnline>) :
    RecyclerView.Adapter<CustomAdapterListDataQuestions.ConnectView>() {
    var listAns: ArrayList<String> = arrayListOf()
    var listAns1: ArrayList<String> = arrayListOf()
    lateinit var currentUser: FirebaseUser

    class ConnectView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noiDung: TextView = itemView.findViewById(R.id.txtQuestions)
        val ansA: RadioButton = itemView.findViewById(R.id.answerA)
        val ansB: RadioButton = itemView.findViewById(R.id.answerB)
        val ansC: RadioButton = itemView.findViewById(R.id.answerC)
        val ansD: RadioButton = itemView.findViewById(R.id.answerD)

        val groupAns: RadioGroup = itemView.findViewById(R.id.groupAns)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectView {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_data_questions_online, parent, false)
        return CustomAdapterListDataQuestions.ConnectView(view)
    }

    override fun onBindViewHolder(holder: ConnectView, position: Int) {
        val activity = holder.itemView.context as Activity
        val questions = list[position].noiDung
        holder.noiDung.text = list[position].noiDung
        val questionsSplit = questions.split("?")
        holder.noiDung.text = questionsSplit[0].toString() + " ?".trim()
        for (question in questionsSplit) {
            val questionParts = question.split(";")
            val questionText = questionParts[0]
            val choices = questionParts.subList(1, questionParts.size)

            println("Câu hỏi: $questionText")
            holder.ansA.text = questionText
            var index = 0
            for (choice in choices) {
                if (index == 0) {
                    holder.ansB.text = choice
                }
                if (index == 1) {
                    holder.ansC.text = choice
                }
                if (index == 2) {
                    holder.ansD.text = choice
                }
                index++
            }
            println()
        }

        // get data answer of client
        var pos = position + 1
        listAns.add("Chưa làm!")
        listAns1.add("Câu $pos: Chưa làm!")
        holder.groupAns.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.answerA -> {
                    listAns.set(position, "A")
                    listAns1.set(position, "Câu $pos: A")
                    var nextPosition = (position + 1)
                    val layoutManager =
                        (holder.itemView.parent as RecyclerView).layoutManager as GridLayoutManager
                    layoutManager.scrollToPosition(nextPosition)
                }

                R.id.answerB -> {
                    listAns.set(position, "B")
                    listAns1.set(position, "Câu $pos: B")
                    var nextPosition = (position + 1)
                    val layoutManager =
                        (holder.itemView.parent as RecyclerView).layoutManager as GridLayoutManager
                    layoutManager.scrollToPosition(nextPosition)
                }
                R.id.answerC -> {
                    listAns.set(position, "C")
                    listAns1.set(position, "Câu $pos: C")

                    var nextPosition = (position + 1)
                    val layoutManager =
                        (holder.itemView.parent as RecyclerView).layoutManager as GridLayoutManager
                    layoutManager.scrollToPosition(nextPosition)
                }
                R.id.answerD -> {
                    listAns.set(position, "D")
                    listAns1.set(position, "Câu $pos: D")
                    var nextPosition = (position + 1)
                    val layoutManager =
                        (holder.itemView.parent as RecyclerView).layoutManager as GridLayoutManager
                    layoutManager.scrollToPosition(nextPosition)
                }
            }
        }

        // submit

        val inflater = LayoutInflater.from(activity)
        val view = inflater.inflate(R.layout.activity_question_online, null)
        val btnSubmit = activity.findViewById<Button>(R.id.btnSubmitOnline)
        val btnMore = activity.findViewById<Button>(R.id.btnMoreOnline)

        btnSubmit.setOnClickListener {
            var point: Double = (10/list.size.toDouble()).toDouble()
            var checkAns: Int = 0
            Toast.makeText(activity, "Nộp bài thành công!", Toast.LENGTH_SHORT).show()
            val answer = list[position].dapAnDung
            for (i in 0..listAns.size - 1) {
                if (listAns[i] == answer[i].toString()) {
                    checkAns++
                }
            }
            Log.e("diem moi cau",point.toString())
            Log.e("so cau dung",checkAns.toString())
            var sumPoint = checkAns.toDouble() * point
            val decimalFormat = DecimalFormat("#.##")
            val formatPoint = decimalFormat.format(sumPoint)
            Log.e("tong diem",formatPoint.toString())

            // save data on firestore database
            val db = Firebase.firestore
            currentUser = FirebaseAuth.getInstance().currentUser!!
            val newData = hashMapOf<String,Double>(
                "Email: "+currentUser.email.toString()+" | Name: ${currentUser.displayName} " to formatPoint.toDouble(),
                )
            val i = activity.intent
            val examsCollectionRef = db.collection("exams").document(i.getStringExtra("id").toString())
            examsCollectionRef.set(mapOf("scores" to newData), SetOptions.merge())
            // back to
            val intent = Intent(activity,ActivityOnline::class.java)
             activity.startActivity(intent)

        }
        // show answer
        btnMore.setOnClickListener {
//
            // custom alert dialog
            val inflater = LayoutInflater.from(activity)
            val view = inflater.inflate(R.layout.custom_dialog, null)
            val lv = view.findViewById<ListView>(R.id.lvAnswer)

            // set adapter
            lv.adapter = ArrayAdapter(activity, android.R.layout.simple_list_item_1, listAns1)

            // on alert
            val dialog = AlertDialog.Builder(activity)
            dialog.setView(view)
            dialog.setTitle("Đáp Án Của Bạn!")
            dialog.show()

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}