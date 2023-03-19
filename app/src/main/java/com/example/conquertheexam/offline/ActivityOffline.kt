package com.example.conquertheexam.offline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conquertheexam.MainActivity
import com.example.conquertheexam.R
import com.example.conquertheexam.databinding.ActivityOfflineBinding

class ActivityOffline : AppCompatActivity() {
    lateinit var binding: ActivityOfflineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline)
        binding = ActivityOfflineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBackHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // toan
        binding.btnToan.setOnClickListener {
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnToan.isClickable){
                intent.putExtra("mon","Toán")
            }
            startActivity(intent)
        }
        // toan
        binding.btnToan.setOnClickListener {
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnToan.isClickable){
                intent.putExtra("mon","Toán")
            }
            startActivity(intent)
        }
        // toan
        binding.btnToan.setOnClickListener {
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnToan.isClickable){
                intent.putExtra("mon","Toán")
            }
            startActivity(intent)
        }
        // li
        binding.btnVatLi.setOnClickListener {
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnVatLi.isClickable){
                intent.putExtra("mon","Vật Lí")
            }
            startActivity(intent)
        }
        // hoa
        binding.btnHoaHoc.setOnClickListener {
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnHoaHoc.isClickable){
                intent.putExtra("mon","Hóa Học")
            }
            startActivity(intent)
        }
        // su
        binding.btnSu.setOnClickListener {
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnSu.isClickable){
                intent.putExtra("mon","Lịch Sử")
            }
            startActivity(intent)
        }
        // dia
        binding.btnDia.setOnClickListener {
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnDia.isClickable){
                intent.putExtra("mon","Địa lí")
            }
            startActivity(intent)
        }
        // GDCD
        binding.btnGDCD.setOnClickListener {
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnGDCD.isClickable){
                intent.putExtra("mon","Giáo Dục Công Dân")
            }
            startActivity(intent)
        }
        // sinh hoc
        binding.btnSinh.setOnClickListener {
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnSinh.isClickable){
                intent.putExtra("mon","Sinh Học")
            }
            startActivity(intent)
        }
        // tieng anh
        binding.btnAnh.setOnClickListener {
            val intent = Intent(this, ActivityExamPapers::class.java)
            if (binding.btnAnh.isClickable){
                intent.putExtra("mon","Tiếng Anh")
            }
            startActivity(intent)
        }

    }
}