package com.example.afinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.afinal.CourseActivity
import com.example.afinal.R
import com.example.afinal.TeacherActivity

class DeptIntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_teacher)

        findViewById<Button>(R.id.btnTCourse).setOnClickListener {
            startActivity(Intent(this, CourseActivity::class.java))
        }

        findViewById<Button>(R.id.btn_IM).setOnClickListener {
            startActivity(Intent(this, TeacherActivity::class.java))
        }
    }
}