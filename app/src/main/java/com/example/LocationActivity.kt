package com.example.afinal

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        val txtLocation = findViewById<TextView>(R.id.txtLocation)
        txtLocation.text = "校園位置功能建置中"
    }
}
