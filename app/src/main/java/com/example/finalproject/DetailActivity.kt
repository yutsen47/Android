package com.example.campusguide

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.ServicesAdapter
import com.example.finalproject.R

class DetailActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val officeName = intent.getStringExtra("office_name")
        val services = intent.getStringArrayListExtra("services") ?: arrayListOf()

        title = officeName

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerServices)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ServicesAdapter(services)
    }
}
