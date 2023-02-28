package com.jaytala.database.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.jaytala.database.R
import com.jaytala.database.StudentModel

class StudentsAdapter(dataList: ArrayList<StudentModel>): RecyclerView.Adapter<StudentsAdapter.StudentsHolder>() {

    var dataList = dataList
    lateinit var context:Context

    class StudentsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var id =itemView.findViewById<TextView>(R.id.id)
        var name =itemView.findViewById<TextView>(R.id.name)
        var surname =itemView.findViewById<TextView>(R.id.surname)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsHolder {
        context=parent.context
        return StudentsHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_item,parent,false))
    }

    override fun onBindViewHolder(holder: StudentsHolder, position: Int) {
        holder.id.text = dataList.get(position).id.toString()
        holder.name.text = dataList.get(position).name
        holder.surname.text = dataList.get(position).surname

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}