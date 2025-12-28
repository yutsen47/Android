package com.example.afinal

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class AdminSearchActivity : AppCompatActivity() {

    private val offices = listOf(
        Office(
            "教務處",
            listOf("教務", "選課", "課程"),
            listOf("選課作業", "課程異動", "學分認定")
        ),
        Office(
            "教務處－註冊組",
            listOf("註冊", "學籍"),
            listOf("在學證明", "學籍異動", "休退學")
        ),
        Office(
            "學務處",
            listOf("學生", "宿舍", "生活"),
            listOf("住宿申請", "獎助學金", "學生輔導")
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_search)

        val autoSearch = findViewById<AutoCompleteTextView>(R.id.autoSearch)

        val suggestions = offices.map { it.name }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            suggestions
        )

        autoSearch.setAdapter(adapter)
        autoSearch.threshold = 1

        autoSearch.setOnItemClickListener { _, _, _, _ ->
            val selectedName = autoSearch.text.toString()
            val selectedOffice = offices.first { it.name == selectedName }

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("office_name", selectedOffice.name)
            intent.putStringArrayListExtra(
                "services",
                ArrayList(selectedOffice.services)
            )
            startActivity(intent)
        }
    }
}
