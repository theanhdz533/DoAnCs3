package com.example.conquertheexam.offline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import com.example.conquertheexam.R
import com.example.conquertheexam.adapter.custom.CustomListViewDeThi
import com.example.conquertheexam.adapter.data.dataDeThi
import com.example.conquertheexam.databinding.ActivityExamPapersBinding

class ActivityExamPapers : AppCompatActivity() {
    private var db:ConnectDB? = null
    lateinit var binding: ActivityExamPapersBinding
    lateinit var listDeThi :MutableList<dataDeThi>
    lateinit var customListViewDeThi: CustomListViewDeThi
    lateinit var mon :String
    lateinit var ma_mon:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_papers)
        binding = ActivityExamPapersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // connect db
        db = ConnectDB(this)
        db?.openDatabase()
        var helper = ConnectDB(applicationContext)
        var data = helper.readableDatabase


        // set adapter
        listDeThi = mutableListOf()



        // lay ten mon hoc
        val i = intent
        mon = i.getStringExtra("mon").toString()
        ma_mon = i.getStringExtra("ma_mon").toString()
        binding.txtTenMonHoc.setText(mon)

        // get data form database
        var rs = data.rawQuery("Select * from ma_de where maMonHoc = '${ma_mon}'",null)
        // data view
        for (i in 0..rs.count-1) {
            if (rs.moveToPosition(i)) {
                listDeThi.add(dataDeThi("Đề "+(i+1),rs.getString(2).toInt()
                    ,rs.getString(1).toInt(),rs.getString(3),rs.getDouble(5)))
            }
        }

        customListViewDeThi = CustomListViewDeThi(this,listDeThi)
        binding.lvDeThi.adapter = customListViewDeThi




        // btn back
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, ActivityOffline::class.java)
            startActivity(intent)
        }

        binding.lvDeThi.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this,ActivityQuestions::class.java)
            val ma_de : String = (ma_mon+(position+1).toString()).toString()
            intent.putExtra("mon",mon)
            intent.putExtra("ma_mon",ma_mon)
            intent.putExtra("ma_de",ma_de)
            intent.putExtra("stt",position)
            intent.putExtra("thoi_gian",rs.getInt(2))
            startActivity(intent)
        }

    }








}