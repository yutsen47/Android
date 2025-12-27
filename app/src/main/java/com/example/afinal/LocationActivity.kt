package com.example.afinal
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        // Demo 用假資料（期末專案 OK）
        findViewById<TextView>(R.id.txtLocation).text =
            "目前位置：\n緯度 25.0330\n經度 121.5654"
    }
}
