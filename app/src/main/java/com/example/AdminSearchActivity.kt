package com.example.afinal

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class AdminSearchActivity : AppCompatActivity() {

    // 行政單位資料模型
    data class Office(
        val name: String,
        val relatedDepartments: List<String>,
        val services: List<String>
    )

    // 行政單位資料
    private val offices = listOf(
        Office(
            "教務處",
            listOf("課務組", "學生組"),
            listOf("課程規劃", "成績查詢", "學籍管理")
        ),
        Office(
            "學務處",
            listOf("宿舍組", "輔導組", "教官組", "招生組"),
            listOf("招生簡章", "住宿申請", "心理輔導", "活動報名系統", "行事曆")
        ),
        Office(
            "總務處",
            listOf("宿舍組", "輔導組", "會計組"),
            listOf("通行證申請", "各單位分機表", "表單申請", "應繳學費及學分費查詢")
        ),
        Office(
            "人事室",
            listOf("教職籍組", "學籍組"),
            listOf("人事招募計畫", "簽到相關作業系統")
        ),
        Office(
            "校牧處",
            emptyList(),
            listOf("生命成長教育認證系統", "撒瑪利亞基金申請")
        ),
        Office(
            "資訊處",
            emptyList(),
            listOf("維修表單", "電子郵件申請", "電腦教室預約系統", "行政教學資源", "校園網路")
        ),
        Office(
            "職涯發展處",
            emptyList(),
            listOf("產業人才培育中心", "職涯輔導中心", "實習心得報告單")
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_search)

        val autoCompleteTextView =
            findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val listView =
            findViewById<ListView>(R.id.listViewDetails)

        // AutoComplete 建議清單（行政單位名稱）
        val officeNames = offices.map { it.name }
        val autoAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            officeNames
        )
        autoCompleteTextView.setAdapter(autoAdapter)

        // 點選某個行政單位後顯示詳細資訊
        autoCompleteTextView.setOnItemClickListener { parent, _, position, _ ->
            val selectedName = parent.getItemAtPosition(position) as String
            val office = offices.find { it.name == selectedName }

            office?.let {
                val details = mutableListOf<String>()

                if (it.relatedDepartments.isNotEmpty()) {
                    details.add("📌 相關部門：${it.relatedDepartments.joinToString("、")}")
                }

                details.add("🛠 可辦理業務：")
                it.services.forEach { service ->
                    details.add("－ $service")
                }

                val detailAdapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    details
                )
                listView.adapter = detailAdapter
            }
        }
    }
}
