package com.example.afinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class IMActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_im)

        // 系所介紹按鈕
        findViewById<Button>(R.id.btnDeptIntro).setOnClickListener {
            startActivity(Intent(this, DeptIntroActivity::class.java))
        }

        // 師資介紹按鈕
        findViewById<Button>(R.id.btnTeacherIntro).setOnClickListener {
            startActivity(Intent(this, TeacherActivity::class.java))
        }
    }
}
