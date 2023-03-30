package com.example.conquertheexam.offline

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conquertheexam.DataAnswer
import com.example.conquertheexam.R
import com.example.conquertheexam.adapter.custom.CustomRecyclerViewQuestions
import com.example.conquertheexam.adapter.data.dataDeThi
import com.example.conquertheexam.adapter.data.dataQuestions
import com.example.conquertheexam.databinding.ActivityQuestionsBinding
import com.example.conquertheexam.databinding.CustomRecyclerviewQuestionsBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.math.log


class ActivityQuestions : AppCompatActivity() {
    private var db: ConnectDB? = null
    lateinit var binding: ActivityQuestionsBinding
    lateinit var listAns: ArrayList<DataAnswer>
    lateinit var sharedPreferences: SharedPreferences
    lateinit var mon: String
    lateinit var ma_de: String
    var stt: Int = 0
    var thoiGian: Int = 0
    var ketThuc :Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // connect db
        db = ConnectDB(this)
        db?.openDatabase()
        var helper = ConnectDB(applicationContext)
        var data = helper.readableDatabase

        // variable
        val viewQuestions = findViewById<RecyclerView>(R.id.rcvListQuestions)

        // add question
        var listQuestions: MutableList<dataQuestions> = mutableListOf()


        // get data
        val intent = intent
        mon = intent.getStringExtra("mon").toString()
        var ma_mon = intent.getStringExtra("ma_mon").toString()
        ma_de = intent.getStringExtra("ma_de").toString()
        stt = intent.getIntExtra("stt", 0)
        val table = "de_thi_" + ma_mon
        thoiGian = intent.getIntExtra("thoi_gian",0)
        binding.txtMaDeThi.setText("Mã Đề: " + (stt + 1).toString())




        // get data form database
        var rs = data.rawQuery("Select * from $table where maDe = '${ma_de}'", null)
        // data view
        for (i in 0..rs.count - 1) {
            if (rs.moveToPosition(i)) {
                listQuestions.add(
                    dataQuestions(
                        rs.getString(0),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        null,
                        rs.getString(8)
                    )
                )
            }
        }

        // set adapter
        viewQuestions.adapter = CustomRecyclerViewQuestions(listQuestions)
        // set layout
        viewQuestions.layoutManager =
            GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)
         // dem nguoc
        demNguoc()
        if (ketThuc){
            binding.txtDemNguoc.setText("Hết Giờ")
            binding.txtDemNguoc.setTextColor(Color.parseColor("#FF0000"))
        }
        // btn back
        binding.btnBackExamPapers.setOnClickListener {
            val i = Intent(this, ActivityExamPapers::class.java)
                i.putExtra("mon",mon)
                i.putExtra("ma_mon",ma_mon)
            startActivity(i)

        }
        // btn submit
        val tongCau = rs.count
        var diem = 10/rs.count
        var soCauDung:Int = 0
        for (i in 0..rs.count - 1) {
            if (rs.moveToPosition(i)){
                if (rs.getString(7)==rs.getString(9)){
                    soCauDung++
                }
            }

        }
        binding.btnSubmit.setOnClickListener {
               Toast.makeText(this,soCauDung.toString(),Toast.LENGTH_SHORT).show()
        }


    }

    // dem nguoc thoi gian
    fun demNguoc() {
        val countDownTimer = object : CountDownTimer((thoiGian * 60 * 1000).toLong(), 1000) {
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
    }


}