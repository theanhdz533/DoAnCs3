package com.example.conquertheexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conquertheexam.databinding.ActivityMainBinding
import com.example.conquertheexam.offline.ActivityOffline

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // btn offline
        binding.btnTuLuyen.setOnClickListener {
              val intent = Intent(this, ActivityOffline::class.java)
             startActivity(intent)
        }
    }
}