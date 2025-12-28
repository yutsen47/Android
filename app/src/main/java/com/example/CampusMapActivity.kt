package com.example.afinal

import android.graphics.RectF
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity

class CampusMapActivity : AppCompatActivity() {

    private var firstPoint: Pair<Float, Float>? = null // 用於生成 RectF 的左上角

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campus_map)

        val imgCampusMap = findViewById<ImageView>(R.id.imgCampusMap)
        val txtFacilityIntro = findViewById<TextView>(R.id.txtFacilityIntro)

        // 已設定的區域百分比
        val zones = listOf(
            Pair(RectF(0.02f, 0.35f, 0.22f, 0.43f), "力行宿舍"),
            Pair(RectF(0.48f, 0.47f, 0.53f, 0.57f), "理學大樓"),
            Pair(RectF(0.31f, 0.34f, 0.48f, 0.48f), "全人村"),
            Pair(RectF(0.59f, 0.41f, 0.63f, 0.46f), "恩惠堂"),
            Pair(RectF(0.65f, 0.36f, 0.73f, 0.45f), "管理大樓/商學大樓"),
            Pair(RectF(0.16f, 0.46f, 0.27f, 0.50f), "活動中心"),
            Pair(RectF(0.39f, 0.50f, 0.47f, 0.60f), "科學館"),
            Pair(RectF(0.24f, 0.25f, 0.37f, 0.32f), "體育館"),
            Pair(RectF(0.68f, 0.56f, 0.77f, 0.64f), "中正樓"),
            Pair(RectF(0.65f, 0.50f, 0.73f, 0.54f), "資管樓"),
            Pair(RectF(0.13f, 0.55f, 0.23f, 0.63f), "張靜愚紀念圖書館"),
            Pair(RectF(0.74f, 0.50f, 0.78f, 0.53f), "商設樓"),
            Pair(RectF(0.14f, 0.69f, 0.28f, 0.74f), "懷恩樓"),
            Pair(RectF(0.78f, 0.56f, 0.86f, 0.60f), "莊敬大樓"),
            Pair(RectF(0.86f, 0.49f, 0.92f, 0.56f), "土木館"),
            Pair(RectF(0.58f, 0.71f, 0.65f, 0.82f), "電信大樓"),
            Pair(RectF(0.46f, 0.71f, 0.59f, 0.88f), "真知教學大樓"),
            Pair(RectF(0.11f, 0.46f, 0.15f, 0.55f), "生科館"),
            Pair(RectF(0.54f, 0.51f, 0.60f, 0.56f), "化學館"),
            Pair(RectF(0.78f, 0.37f, 0.84f, 0.49f), "工學館"),
            Pair(RectF(0.79f, 0.23f, 0.87f, 0.30f), "熱誠宿舍"),
            Pair(RectF(0.88f, 0.23f, 0.96f, 0.31f), "信實宿舍"),
            Pair(RectF(0.90f, 0.57f, 0.96f, 0.60f), "室設館"),
            Pair(RectF(0.94f, 0.60f, 0.97f, 0.65f), "望樓"),
            Pair(RectF(0.63f, 0.83f, 0.70f, 0.91f), "良善宿舍"),
            Pair(RectF(0.71f, 0.80f, 0.78f, 0.91f), "恩慈宿舍"),
            Pair(RectF(0.71f, 0.68f, 0.75f, 0.78f), "建築館"),
            Pair(RectF(0.74f, 0.68f, 0.81f, 0.72f), "祐生建築中心"),
            Pair(RectF(0.90f, 0.67f, 0.92f, 0.71f), "設計學院"),
            Pair(RectF(0.92f, 0.66f, 0.97f, 0.60f), "景觀館"),
            Pair(RectF(0.29f, 0.76f, 0.44f, 0.87f), "維澈樓"),
            Pair(RectF(0.38f, 0.64f, 0.44f, 0.74f), "行政大樓")
        )

        imgCampusMap.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {

                val drawable = imgCampusMap.drawable
                val intrinsicWidth = drawable.intrinsicWidth.toFloat()
                val intrinsicHeight = drawable.intrinsicHeight.toFloat()

                val scaleX = intrinsicWidth / imgCampusMap.width
                val scaleY = intrinsicHeight / imgCampusMap.height

                // 百分比座標
                val percentX = (event.x * scaleX) / intrinsicWidth
                val percentY = (event.y * scaleY) / intrinsicHeight

                // ---------- 校園設施匹配 ----------
                var matched = false
                for ((rect, desc) in zones) {
                    if (percentX in rect.left..rect.right && percentY in rect.top..rect.bottom) {
                        txtFacilityIntro.text = "設施：$desc\n座標：%.3f, %.3f".format(percentX, percentY)
                        matched = true
                        break
                    }
                }

                if (!matched) {
                    txtFacilityIntro.text =
                        "校園設施介紹：\n本校包含教學大樓、圖書館、運動場等設施。\n座標：%.3f, %.3f".format(percentX, percentY)
                }

                // ---------- RectF 百分比工具功能 ----------
                if (firstPoint == null) {
                    firstPoint = Pair(percentX, percentY)
                    txtFacilityIntro.append("\n\n【工具】左上角點選完成，請點右下角")
                } else {
                    val left = firstPoint!!.first
                    val top = firstPoint!!.second
                    val right = percentX
                    val bottom = percentY
                    val rect = RectF(left, top, right, bottom)
                    txtFacilityIntro.append(
                        "\n【工具】生成 RectF = RectF(%.3ff, %.3ff, %.3ff, %.3ff)".format(
                            rect.left, rect.top, rect.right, rect.bottom
                        )
                    )
                    firstPoint = null
                }
            }
            true
        }
    }
}
