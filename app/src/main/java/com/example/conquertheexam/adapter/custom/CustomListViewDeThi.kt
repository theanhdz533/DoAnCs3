package com.example.conquertheexam.adapter.custom

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.conquertheexam.offline.ActivityExamPapers
import com.example.conquertheexam.R
import com.example.conquertheexam.adapter.data.dataDeThi

class CustomListViewDeThi(val activity: ActivityExamPapers, val list:List<dataDeThi>):ArrayAdapter<dataDeThi>(activity,
    R.layout.custom_listview_dethi) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val context = activity.layoutInflater

        val rowList = context.inflate(R.layout.custom_listview_dethi,parent,false)

        val ten = rowList.findViewById<TextView>(R.id.txtTenDe)
        val thoiGian = rowList.findViewById<TextView>(R.id.txtThoiGian)
        val soCau = rowList.findViewById<TextView>(R.id.txtSoCau)
        val tinhTrang = rowList.findViewById<TextView>(R.id.txtTinhTrang)

        ten.setText("Mã đề:"+list[position].maDe)
        thoiGian.setText("Thời gian: "+list[position].thoiGian.toString()+" phút ")
        soCau.setText("Số câu: "+ list[position].soCau.toString()+" câu")
        if (list[position].diem != null){
            tinhTrang.setText("Điểm số: "+list[position].diem)
        }

        return rowList
    }
}