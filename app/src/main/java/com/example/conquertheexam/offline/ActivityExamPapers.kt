package com.example.conquertheexam.offline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conquertheexam.R
import com.example.conquertheexam.adapter.custom.CustomListViewDeThi
import com.example.conquertheexam.adapter.data.dataDeThi
import com.example.conquertheexam.databinding.ActivityExamPapersBinding

class ActivityExamPapers : AppCompatActivity() {
    lateinit var binding: ActivityExamPapersBinding
    lateinit var listDeThi :MutableList<dataDeThi>
    lateinit var customListViewDeThi: CustomListViewDeThi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_papers)
        binding = ActivityExamPapersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set adapter
        listDeThi = mutableListOf()
        listDeThi.add(dataDeThi("Đề 1",120,50,"Chưa làm"))
        listDeThi.add(dataDeThi("Đề 2",120,50,"Chưa làm"))
        listDeThi.add(dataDeThi("Đề 3",120,50,"Chưa làm"))

        customListViewDeThi = CustomListViewDeThi(this,listDeThi)
        binding.lvDeThi.adapter = customListViewDeThi

        // lay ten mon hoc
        val i = intent
        val mon =i.getStringExtra("mon")
        binding.txtTenMonHoc.setText(mon.toString())

        // btn back
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, ActivityOffline::class.java)
            startActivity(intent)
        }


    }


}