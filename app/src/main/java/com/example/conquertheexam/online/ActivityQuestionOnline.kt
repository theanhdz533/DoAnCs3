package com.example.conquertheexam.online

import android.content.Intent
import android.graphics.Color
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conquertheexam.R
import com.example.conquertheexam.adapter.custom.CustomRecyclerViewQuestions
import com.example.conquertheexam.adapter.data.dataQuestions
import com.example.conquertheexam.databinding.ActivityQuestionOnlineBinding
import com.example.conquertheexam.databinding.CustomDataQuestionsOnlineBinding
import com.example.conquertheexam.online.adapter.CustomAdapterListDataExam
import com.example.conquertheexam.online.adapter.CustomAdapterListDataQuestions
import com.example.conquertheexam.online.adapter.EventClickInterFace
import com.example.conquertheexam.online.model.DataAdapterExam
import com.example.conquertheexam.online.model.DataQuestionsOnline
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ActivityQuestionOnline : AppCompatActivity() {
    lateinit var binding: ActivityQuestionOnlineBinding
    var ketThuc: Boolean = false
    var time : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_online)
        binding = ActivityQuestionOnlineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val i = intent
        val viewQuestions = findViewById<RecyclerView>(R.id.rcvListQuestions)
        var listQuestions: MutableList<DataQuestionsOnline> = mutableListOf()
        // set data
        binding.btnBack.setOnClickListener {
            val intent = Intent(this,ActivityOnline::class.java)
            startActivity(intent)
        }
        val db = Firebase.firestore
        val collection = db.collection("exams").document(i.getStringExtra("id").toString())
        collection.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                   var content = document.getString("content")!!.trim()
                    var answer = document.getString("answer")!!.trim()
                    val questions = content.toString()

                    val questionsSplit = questions.split("@")
                    for (question in questionsSplit) {
//                        val questionParts = question.split("@")
//                        val questionText = questionParts[0]
//                        println("$questionText")
                        listQuestions.add(DataQuestionsOnline(question,answer,null))
                    }
                    listQuestions.removeLast()


                    // set time
                    time = document.getLong("time")!!
                    // thoi gian
                    val countDownTimer =
                        object : CountDownTimer((time * 60 * 1000).toLong(), 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            val minute = millisUntilFinished / 1000 / 60
                            val second = millisUntilFinished / 1000 % 60
                            binding.txtDemNguoc.setText("$minute:$second")

                        }

                        override fun onFinish() {
                            ketThuc = true
                        }
                    }
                    countDownTimer.start()
                    // set name de thi
                    binding.txtMaDeThi.text = document.getString("name")


                }
                viewQuestions.adapter = CustomAdapterListDataQuestions(listQuestions)
            }
            .addOnFailureListener { exception ->
                Log.w("Firestore", "Error getting documents: ", exception)
            }

        // set adapter

        // set layout
        viewQuestions.layoutManager =
            GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)



    }
}