package com.example.afinal

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val titleText = findViewById<TextView>(R.id.titleText)
        val serviceList = findViewById<ListView>(R.id.serviceList)

        val officeName = intent.getStringExtra("office_name")
        val services = intent.getStringArrayListExtra("services")

        titleText.text = officeName

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            services ?: emptyList()
        )

        serviceList.adapter = adapter
    }
}
