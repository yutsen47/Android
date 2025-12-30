package com.example.afinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TeacherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        // RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerTeachers)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = TeacherAdapter(TeacherData.teachers)

        // btnTCourse 點擊事件
        findViewById<Button>(R.id.btnTCourse).setOnClickListener {
            // 跳轉到顯示教師課程頁面，例如 TCourseActivity
            startActivity(Intent(this, TCourseActivity::class.java))
        }
    }
}
