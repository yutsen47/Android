package com.example.afinal

import android.R.attr.name
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.R
import com.example.afinal.Teacher


class TeacherAdapter(private val teachers: List<Teacher>) :
    RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.teacherPhoto)
        val name: TextView = itemView.findViewById(R.id.teacherName)
        val title: TextView = itemView.findViewById(R.id.teacherTitle)
        val specialty: TextView = itemView.findViewById(R.id.teacherSpecialty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_teacher, parent, false)
        return TeacherViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val teacher = teachers[position]
        holder.name.text = teacher.name
        holder.photo.setImageResource(teacher.photoResId)
        holder.title.text = teacher.title
        holder.specialty.text = teacher.specialty
    }

    override fun getItemCount() = teachers.size
}