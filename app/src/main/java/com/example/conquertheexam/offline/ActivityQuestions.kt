package com.example.conquertheexam.offline

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conquertheexam.R
import com.example.conquertheexam.adapter.custom.CustomListViewSubmit
import com.example.conquertheexam.adapter.custom.CustomRecyclerViewQuestions
import com.example.conquertheexam.adapter.data.dataDeThi
import com.example.conquertheexam.adapter.data.dataQuestions
import com.example.conquertheexam.adapter.data.dataSubmit
import com.example.conquertheexam.databinding.ActivityQuestionsBinding


class ActivityQuestions : AppCompatActivity() {
    private var db: ConnectDB? = null
    lateinit var binding: ActivityQuestionsBinding
    lateinit var customListViewSubmit: CustomListViewSubmit
    lateinit var mon: String
    lateinit var ma_de: String
    var stt: Int = 0
    var thoiGian: Int = 0
    var ketThuc: Boolean = false

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
        thoiGian = intent.getIntExtra("thoi_gian", 0)
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
        if (ketThuc) {
            binding.txtDemNguoc.setText("Hết Giờ")
            binding.txtDemNguoc.setTextColor(Color.parseColor("#FF0000"))
        }
        // btn back
        binding.btnBackExamPapers.setOnClickListener {
            val i = Intent(this, ActivityExamPapers::class.java)
            i.putExtra("mon", mon)
            i.putExtra("ma_mon", ma_mon)
            startActivity(i)

        }
        // btn submit


        binding.btnSubmit.setOnClickListener {
            var rsAgain = data.rawQuery("Select * from $table where maDe = '${ma_de}'", null)

            //  alert dialog
            //  alert dialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Bạn có chắc chắn muốn nộp bài!")
           builder.setNegativeButton("Hủy"){dialog,which->
               dialog.dismiss()
           }
            builder.setPositiveButton("Đồng Ý"){dialog,which->

                var diem : Double = 0.0
                val diemMoiCau : Double = 10 / rs.count.toDouble()
                var soCauDung:Int = 0


                val inflater = LayoutInflater.from(this)
                val view = inflater.inflate(R.layout.custom_dialog_submit, null)
                val list = arrayListOf<dataSubmit>()
                for (i in 0..rsAgain.count-1) {
                    if (rsAgain.moveToPosition(i)) {
                       list.add(dataSubmit(rsAgain.getString(2),rsAgain.getString(9),
                           rsAgain.getString(7),rsAgain.getString(8)))
                        if (rsAgain.getString(7)==rsAgain.getString(9)){
                            soCauDung++
                        }
                    }
                }
                val lv = view.findViewById<ListView>(R.id.lvSubmit)
                val btnXacNhan = view.findViewById<Button>(R.id.btnXacNhan)
                customListViewSubmit = CustomListViewSubmit(this,list)
                lv.adapter = customListViewSubmit

                // show dialog
                val tongDiem : Double = diemMoiCau * soCauDung.toDouble()
                val dialog = AlertDialog.Builder(this)
                dialog.setView(view)
                dialog.setTitle( "Điểm số: "+tongDiem+" - Số câu đúng: " + soCauDung+"/"+rs.count)
                btnXacNhan.setOnClickListener {
                    for (i in 0..rsAgain.count-1){
                        data.execSQL("update $table set dapAnChon='' where cau = '${rs.count-i}' and maDe='$ma_de' ")
                    }
                    data.execSQL("update ma_de set diem='${tongDiem}' where maDe='$ma_de'")

                    val i = Intent(this, ActivityExamPapers::class.java)
                    i.putExtra("mon", mon)
                    i.putExtra("ma_mon", ma_mon)
                    startActivity(i)
                }
                dialog.setCancelable(false)
                dialog.show()



            }
            builder.setCancelable(false)
            builder.show()



        }
        // btn more
        binding.btnMore.setOnClickListener {
            // get data
            var rsAgain = data.rawQuery("Select * from $table where maDe = '${ma_de}'", null)
            val listAns      = arrayListOf<String>()
            for (i in 0..rsAgain.count-1){
                if (rsAgain.moveToPosition(i)){
                    listAns.add("Câu "+(i+1).toString()+" : "+rsAgain.getString(9))
                }
            }

            // custom alert dialog
            val inflater = LayoutInflater.from(this)
            val view = inflater.inflate(R.layout.custom_dialog, null)
            val lv = view.findViewById<ListView>(R.id.lvAnswer)

            // set adapter
            lv.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listAns)

            // on alert
            val dialog = AlertDialog.Builder(this)
            dialog.setView(view)
            dialog.setTitle("Đáp Án Của Bạn!")
            dialog.show()

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