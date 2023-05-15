package com.example.conquertheexam.online

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.conquertheexam.R
import com.example.conquertheexam.databinding.ActivityExamPaperBinding
import com.google.errorprone.annotations.Var
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.parser.PdfTextExtractor

class ActivityExamPaper : AppCompatActivity() {
    lateinit var currentUser : FirebaseUser
    lateinit var binding: ActivityExamPaperBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_paper)
        binding = ActivityExamPaperBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(intent.getStringExtra("pdf")!!.isEmpty()){
            binding.edtContent.setText("Chờ tớ một xíu...")
        }
        else {
            binding.edtContent.setText(intent.getStringExtra("pdf"))
        }
        var count:Int = 0

            binding.btnSubmit.setOnClickListener {
                if (binding.edtTime.text.toString().isEmpty()){
                    binding.edtTime.error = "Vui lòng nhập vào đây!"
                    count++
                }
                if (binding.edtAnswer.text.toString().isEmpty()){
                    binding.edtAnswer.error = "Vui lòng nhập vào đây!"
                    count++
                }
                if (binding.edtName.text.toString().isEmpty()){
                    binding.edtName.error = "Vui lòng nhập vào đây!"
                    count++
                }
                if (count==0){
                    val db = Firebase.firestore
                    currentUser = FirebaseAuth.getInstance().currentUser!!
                    val examsCollectionRef = db.collection("exams")
                    examsCollectionRef.add(
                        hashMapOf(
                            "creator" to  currentUser.email.toString(),
                            "content" to intent.getStringExtra("pdf"),
                            "time" to binding.edtTime.text.toString().toInt(),
                            "name" to binding.edtName.text.toString(),
                            "answer" to binding.edtAnswer.text.toString().toUpperCase(),
                            "password" to binding.edtPass.text.toString(),
                            "scores" to emptyMap<String,Double>(),
                        )
                    ).addOnSuccessListener {
                       val intent = Intent(this,ActivityOnline::class.java)
                        startActivity(intent)
                    }.addOnFailureListener { e ->

                    }
                }
            }



    }

}