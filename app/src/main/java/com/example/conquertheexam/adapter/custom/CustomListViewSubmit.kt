package com.example.conquertheexam.adapter.custom

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.conquertheexam.R
import com.example.conquertheexam.adapter.data.dataSubmit
import com.example.conquertheexam.offline.ConnectDB

class CustomListViewSubmit(val activity: Activity,val list: List<dataSubmit>):ArrayAdapter<dataSubmit>(activity,
    R.layout.custom_listview_dialog_submit) {
    private var db: ConnectDB? = null
    override fun getCount(): Int {
       return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val context = activity.layoutInflater

        val rowList = context.inflate(R.layout.custom_listview_dialog_submit,parent,false)

        val cauHoi = rowList.findViewById<TextView>(R.id.txtCauHoi)
        val dapAnChon = rowList.findViewById<TextView>(R.id.txtDapAnChon)
        val dapAnDung = rowList.findViewById<TextView>(R.id.txtDapAnDung)
        val loiGiai = rowList.findViewById<TextView>(R.id.txtLoiGiai)

        cauHoi.setText("Câu "+(position+1).toString()+" : "+list[position].cauHoi)

        if (list[position].dapAnChon==list[position].dapAnDung){
            dapAnChon.setText("Đáp án của bạn: "+list[position].dapAnChon+"-> Đúng")
            dapAnChon.setTextColor(Color.parseColor("#00C853"))
        }
        else {
            dapAnChon.setText("Đáp án của bạn: "+list[position].dapAnChon+"-> Sai")
            dapAnChon.setTextColor(Color.parseColor("#D50000"))
        }
        dapAnDung.setText("Đáp án đúng: "+list[position].dapAnDung)
        if (list[position].loiGiai == null){
            loiGiai.setText("Lời giải: Không có!:(")
        }
        else {
            loiGiai.setText("Lời giải: "+list[position].loiGiai)
        }



        return rowList
    }
}