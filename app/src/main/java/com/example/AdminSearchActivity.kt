package com.example.afinal

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class AdminSearchActivity : AppCompatActivity() {

    data class Office(
        val name: String,
        val relatedDepartments: List<String>,
        val services: List<String>
    )

    private val offices = listOf(
        Office("教務處", listOf("課務組", "學生組"), listOf("課程規劃", "成績查詢", "學籍管理")),
        Office("學務處", listOf("宿舍組", "輔導組", "教官組", "招生組"), listOf("招生簡章", "住宿申請", "心理輔導", "活動報名系統", "行事曆")),
        Office("總務處", listOf("宿舍組", "輔導組", "會計組"), listOf("通行證申請", "各單位分機表", "表單申請", "應繳學費及學分費查詢")),
        Office("人事室", listOf("教職籍組", "學籍組"), listOf("人事招募計畫", "簽到相關作業系統")),
        Office("校牧處", emptyList(), listOf("生命成長教育認證系統", "撒瑪利亞基金申請")),
        Office("資訊處", emptyList(), listOf("維修表單", "電子郵件申請", "電腦教室預約系統", "行政教學資源", "校園網路")),
        Office("職涯發展處", emptyList(), listOf("產業人才培育中心", "職涯輔導中心", "實習心得報告單"))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_search)

        val listView = findViewById<ListView>(R.id.listViewDetails)
        val searchBox = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        // 1️⃣ 只顯示 Office name
        val officeNames = offices.map { it.name }.toMutableList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, officeNames)
        listView.adapter = adapter

        // 2️⃣ 即時搜尋
        searchBox.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().trim()
                val filtered = if (query.isEmpty()) {
                    offices.map { it.name }
                } else {
                    offices.filter { it.name.contains(query) }.map { it.name }
                }
                adapter.clear()
                adapter.addAll(filtered)
                adapter.notifyDataSetChanged()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // 3️⃣ 點擊 Office 顯示詳細內容
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedName = adapter.getItem(position) ?: return@setOnItemClickListener
            val office = offices.find { it.name == selectedName } ?: return@setOnItemClickListener

            val builder = AlertDialog.Builder(this)
            builder.setTitle(office.name)

            val content = StringBuilder()
            if (office.relatedDepartments.isNotEmpty()) {
                content.append("📌 相關部門：${office.relatedDepartments.joinToString("、")}\n\n")
            }
            content.append("🛠 可辦理業務：\n")
            office.services.forEach { service ->
                content.append("－ $service\n")
            }

            builder.setMessage(content.toString())
            builder.setPositiveButton("確定", null)
            builder.show()
        }
    }
}
