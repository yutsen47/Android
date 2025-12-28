package com.example.afinal

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

// 課程資料模型
data class Course(
    val code: String,   // 課程代碼
    val name: String,   // 課程名稱
    val teacher: String,// 教師
    val time: String,   // 時間 (例如：星期2 5-6)
    val room: String    // 教室
)

class CourseActivity : AppCompatActivity() {

    private val courseList = mutableListOf<Course>()
    private var currentList = mutableListOf<Course>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        val edtKeyword = findViewById<EditText>(R.id.edtKeyword)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val listView = findViewById<ListView>(R.id.listViewCourses)

        // 讀取 CSV
        loadCoursesFromCSV()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, courseList.map { "${it.code} ${it.name}" })
        listView.adapter = adapter
        currentList = courseList.toMutableList()

        // 🔍 查詢
        btnSearch.setOnClickListener {
            val keyword = edtKeyword.text.toString().trim()
            currentList = if (keyword.isEmpty()) courseList.toMutableList()
            else courseList.filter { it.name.contains(keyword, ignoreCase = true) || it.code.contains(keyword, ignoreCase = true) }.toMutableList()

            adapter.clear()
            adapter.addAll(currentList.map { "${it.code} ${it.name}" })
            adapter.notifyDataSetChanged()
        }

        // 點擊課程顯示詳細資訊
        listView.setOnItemClickListener { _, _, position, _ ->
            val c = currentList[position]
            val details = """
                課程代碼: ${c.code}
                課程名稱: ${c.name}
                教師: ${c.teacher}
                時間: ${c.time}
                教室: ${c.room}
            """.trimIndent()

            AlertDialog.Builder(this)
                .setTitle("課程詳情")
                .setMessage(details)
                .setPositiveButton("關閉", null)
                .show()
        }
    }

    // 讀取 CSV
    private fun loadCoursesFromCSV() {
        try {
            val input = assets.open("courses.csv")
            val reader = BufferedReader(InputStreamReader(input))
            reader.lineSequence().drop(1).forEach { line -> // 跳過表頭
                val tokens = line.split(",")
                if (tokens.size >= 5) {
                    courseList.add(Course(
                        code = tokens[0],
                        name = tokens[1],
                        teacher = tokens[2],
                        time = tokens[3],
                        room = tokens[4]
                    ))
                }
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "讀取 CSV 失敗", Toast.LENGTH_SHORT).show()
        }
    }
}
