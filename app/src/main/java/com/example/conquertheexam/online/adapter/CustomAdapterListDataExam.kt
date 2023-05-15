package com.example.conquertheexam.online.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.conquertheexam.R
import com.example.conquertheexam.online.model.DataAdapterExam
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CustomAdapterListDataExam(val list: List<DataAdapterExam>,val onclick:EventClickInterFace):RecyclerView.Adapter<CustomAdapterListDataExam.ConnectView>() {
  class ConnectView(itemView :View):RecyclerView.ViewHolder(itemView){
       val name : TextView = itemView.findViewById(R.id.txtName)
       val time : TextView = itemView.findViewById(R.id.txtTime)
       val creator : TextView = itemView.findViewById(R.id.txtCreator)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectView {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_adapter_exam_online,parent,false)
    return ConnectView(view)
  }

  override fun onBindViewHolder(holder: ConnectView, position: Int) {
        holder.itemView.apply {
            holder.name.text = list[position].name
            holder.time.text = "Thời gian: "+list[position].time.toString()+ " phút"
            holder.creator.text = "Người tạo: "+list[position].creator

        }
      // set event for item
      holder.itemView.setOnClickListener {
          onclick.OnClickItem(position)
      }
  }

  override fun getItemCount(): Int {
    return list.size
  }
}