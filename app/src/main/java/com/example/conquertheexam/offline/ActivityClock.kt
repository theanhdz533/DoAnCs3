package com.example.conquertheexam.offline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.conquertheexam.R
import com.example.conquertheexam.databinding.ActivityClockBinding
import java.util.*

class ActivityClock : AppCompatActivity() {
    lateinit var binding: ActivityClockBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)
        binding = ActivityClockBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // btn back
        binding.btnBack.setOnClickListener {
            val intent = Intent(this,ActivityOffline::class.java)
            startActivity(intent)
        }
        //dem nguoc
        val endTime = Calendar.getInstance().apply {
            set(2023, Calendar.JUNE, 28, 0, 0, 0) // Set ngày đến hạn
        }.timeInMillis

        val currentTime = System.currentTimeMillis()

        val timeDiff = endTime - currentTime // Tính thời gian còn lại đến ngày 28/06/2023

        val countDownTimer = object : CountDownTimer(timeDiff, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val days = millisUntilFinished / (24 * 60 * 60 * 1000) // Tính số ngày còn lại
                val hours = (millisUntilFinished / (60 * 60 * 1000)) % 24 // Tính số giờ còn lại
                val minutes = (millisUntilFinished / (60 * 1000)) % 60 // Tính số phút còn lại
                val seconds = (millisUntilFinished / 1000) % 60 // Tính số giây còn lại

                val countDownText = "$days ngày, $hours giờ, $minutes phút, $seconds giây"
                // Gán giá trị đếm ngược vào TextView
                binding.txtTime.text = "$days Ngày : $hours Giờ                   $minutes Phút : $seconds Giây"
            }

            override fun onFinish() {
                // Thực hiện hành động khi đếm ngược kết thúc

            }
        }

        countDownTimer.start()
    }
}