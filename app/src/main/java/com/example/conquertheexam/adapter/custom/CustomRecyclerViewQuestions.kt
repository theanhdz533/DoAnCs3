package com.example.conquertheexam.adapter.custom

import android.app.Activity
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conquertheexam.R
import com.example.conquertheexam.adapter.data.dataQuestions
import com.example.conquertheexam.offline.ConnectDB

class CustomRecyclerViewQuestions(val list: List<dataQuestions>) :
    RecyclerView.Adapter<CustomRecyclerViewQuestions.viewHolder>() {
    // open database
    private var db: ConnectDB? = null
    val ans = arrayListOf<String>()
    lateinit var sharedPreferrences: SharedPreferences


    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val noiDung: TextView = view.findViewById(R.id.txtQuestions)
        val stt: TextView = view.findViewById(R.id.txtSTT)
        val ansA: RadioButton = view.findViewById(R.id.answerA)
        val ansB: RadioButton = view.findViewById(R.id.answerB)
        val ansC: RadioButton = view.findViewById(R.id.answerC)
        val ansD: RadioButton = view.findViewById(R.id.answerD)

        val groupAns: RadioGroup = view.findViewById(R.id.groupAns)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomRecyclerViewQuestions.viewHolder {
        val connectView = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_recyclerview_questions, parent, false)
        return CustomRecyclerViewQuestions.viewHolder(connectView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val pos = position + 1
        val activity = holder.itemView.context as Activity

        holder.noiDung.text = list[position].noiDung
        holder.ansA.text = list[position].A
        holder.ansB.text = list[position].B
        holder.ansC.text = list[position].C
        holder.ansD.text = list[position].D
        holder.stt.text = "Câu " + pos.toString() + " : "

        val layout = LayoutInflater.from(holder.itemView.context)
        val layout1 = layout.inflate(R.layout.activity_questions, null)

         // database

        db = ConnectDB(activity)
        db?.openDatabase()
        var helper = ConnectDB(activity.applicationContext)
        var data = helper.readableDatabase

        // data tung mon
        val intent = activity.intent
        val mon = intent.getStringExtra("mon").toString()
        val ma_mon = intent.getStringExtra("ma_mon").toString()
        val ma_de = intent.getStringExtra("ma_de").toString()
        val table = "de_thi_" + ma_mon

        var rs = data.rawQuery("Select * from $table where maDe = '${ma_de}'", null)
        val btnSubmit = activity.findViewById<Button>(R.id.btnSubmit)

        // answer
        ans.add("No")
        holder.groupAns.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.answerA -> {
                    ans.set(position, holder.ansA.text.toString())
                    data.execSQL("update $table set dapAnChon='${ans[position]}' where cau = '${rs.count-position}' and maDe='$ma_de' ")
                    var nextPosition = (position + 1)
                    val layoutManager =
                        (holder.itemView.parent as RecyclerView).layoutManager as GridLayoutManager
                    layoutManager.scrollToPosition(nextPosition)
                }

                R.id.answerB -> {
                    ans.set(position, holder.ansB.text.toString())
                    data.execSQL("update $table set dapAnChon='${ans[position]}' where cau = '${rs.count-position}' and maDe='$ma_de' ")
                    var nextPosition = (position + 1)
                    val layoutManager =
                        (holder.itemView.parent as RecyclerView).layoutManager as GridLayoutManager
                    layoutManager.scrollToPosition(nextPosition)
                }
                R.id.answerC -> {
                    ans.set(position, holder.ansC.text.toString())
                    data.execSQL("update $table set dapAnChon='${ans[position]}' where cau = '${rs.count-position}' and maDe='$ma_de' ")
                    var nextPosition = (position + 1)
                    val layoutManager =
                        (holder.itemView.parent as RecyclerView).layoutManager as GridLayoutManager
                    layoutManager.scrollToPosition(nextPosition)
                }
                R.id.answerD -> {
                    ans.set(position, holder.ansD.text.toString())
                    data.execSQL("update $table set dapAnChon='${ans[position]}' where cau = '${rs.count-position}' and maDe='$ma_de' ")
                    var nextPosition = (position + 1)
                    val layoutManager = (holder.itemView.parent as RecyclerView).layoutManager as GridLayoutManager
                    layoutManager.scrollToPosition(nextPosition)
                }
            }
        }






    }


    override fun getItemCount(): Int {
        return list.size
    }


}