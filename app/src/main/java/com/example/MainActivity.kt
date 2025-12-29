package com.example.afinal

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val buttons = listOf(
            findViewById<Button>(R.id.btnMap),
            findViewById<Button>(R.id.btnAdmin),
            findViewById<Button>(R.id.btn_IM),
            findViewById<Button>(R.id.btnCourse),
            findViewById<Button>(R.id.btnSpot),
            findViewById<Button>(R.id.btnFood)
        )

        buttons.forEach { button ->
            // 縮放動畫
            button.setOnTouchListener { v, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> v.animate().scaleX(0.95f).scaleY(0.95f).duration = 100
                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> v.animate().scaleX(1f).scaleY(1f).duration = 100
                }
                false
            }

            // 持續浮動動畫
            val animator = ObjectAnimator.ofFloat(button, "translationY", 0f, -10f, 0f)
            animator.duration = 1000
            animator.repeatCount = ValueAnimator.INFINITE
            animator.start()
        }

        // 點擊事件
        findViewById<Button>(R.id.btnMap).setOnClickListener { startActivity(Intent(this, CampusMapActivity::class.java)) }
        findViewById<Button>(R.id.btnAdmin).setOnClickListener { startActivity(Intent(this, AdminSearchActivity::class.java)) }
        findViewById<Button>(R.id.btn_IM).setOnClickListener { startActivity(Intent(this, IMActivity::class.java)) }
        findViewById<Button>(R.id.btnCourse).setOnClickListener { startActivity(Intent(this, CourseActivity::class.java)) }
        findViewById<Button>(R.id.btnSpot).setOnClickListener { startActivity(Intent(this, SpotActivity::class.java)) }
        findViewById<Button>(R.id.btnFood).setOnClickListener { startActivity(Intent(this, FoodActivity::class.java)) }
    }
}
