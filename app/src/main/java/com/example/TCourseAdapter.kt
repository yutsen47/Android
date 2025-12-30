package com.example.afinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TCourseAdapter(private val courses: List<TCourse>) :
    RecyclerView.Adapter<TCourseAdapter.CourseViewHolder>() {

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tcourseName: TextView = itemView.findViewById(R.id.tcourseName)
        val tcourseTeacher: TextView = itemView.findViewById(R.id.tcourseTeacher)
        val tcourseContent: TextView = itemView.findViewById(R.id.tcourseContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.tcourseName.text = course.name
        holder.tcourseTeacher.text = course.teacher
        holder.tcourseContent.text = course.content
    }


    override fun getItemCount() = courses.size
}
