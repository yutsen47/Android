package com.example.afinal

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupCategory)
        val edtSearch = findViewById<EditText>(R.id.edtSearch)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val listView = findViewById<ListView>(R.id.listViewFood)
        var selectedMealTime: MealTime? = null

        val foodList = listOf(
            Food(
                "集英會牛肉麵館",
                listOf(MealTime.LUNCH, MealTime.DINNER),
                "桃園市中壢區三和一街27號",
                "11:00-21:30",
                R.drawable.food1
            ),

            Food(
                "老師傅牛肉麵",
                listOf(MealTime.LUNCH, MealTime.DINNER), // ⭐ 午＋晚
                "桃園市中壢區力行北街77號",
                "11:00-15:30/17:00-22:30（周一公休）",
                R.drawable.food2
            ),

            Food(
                "御冠園鮮肉湯包專賣店",
                listOf(MealTime.LUNCH, MealTime.DINNER),
                "桃園市中壢區實踐路88號",
                "06:00-00:30",
                R.drawable.food3
            ),
            Food(
                "麵屋Luna",
                listOf(MealTime.LUNCH, MealTime.DINNER), // ⭐ 午＋晚
                "桃園市中壢區新中北路240號",
                "11:30-14:00/17:00-21:00（周四公休）",
                R.drawable.food4
            ),
            Food(
                "Mint Pasta",
                listOf(MealTime.LUNCH, MealTime.DINNER), // ⭐ 午＋晚
                "桃園市中壢區新中北路61號",
                "11:00-22:00",
                R.drawable.food5
            ),
            Food(
                "大嗑 Brunch",
                listOf(MealTime.LUNCH, MealTime.BREAKFAST), // ⭐ 午＋晚
                "桃園市中壢區弘揚路59號",
                "07:00-14:30",
                R.drawable.food6
            ),
            Food(
                "Eating brunch&dinner",
                listOf(MealTime.BREAKFAST,MealTime.LUNCH, MealTime.DINNER), // ⭐ 午＋晚
                "桃園市中壢區新中北路379號",
                "10:00-21:00",
                R.drawable.food7
            ),
            Food(
                "泰美味",
                listOf(MealTime.LUNCH, MealTime.DINNER), // ⭐ 午＋晚
                "桃園市中壢區大仁三街2-1號",
                "11:30-14:00/17:00-21:00",
                R.drawable.food8
            ),
            Food(
                "泰美味",
                listOf(MealTime.LUNCH, MealTime.DINNER), // ⭐ 午＋晚
                "桃園市中壢區大仁三街2-1號",
                "11:30-14:00/17:00-21:00",
                R.drawable.food8
            ),
            Food(
                "SU DAK",
                listOf(MealTime.LUNCH, MealTime.DINNER), // ⭐ 午＋晚
                "桃園市中壢區大仁五街22號",
                "周一至周五11:00-14:00/17:00-21:00，周六至周日11:00-14:30/17:00-21:00",
                R.drawable.food9
            ),
        )
        var currentList = foodList

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            currentList.map { it.name }
        )
        listView.adapter = adapter

        // 🔁 查詢按鈕
        btnSearch.setOnClickListener {

            // ⭐ 早 / 午 / 晚 選擇
            selectedMealTime = when (radioGroup.checkedRadioButtonId) {
                R.id.radioBreakfast -> MealTime.BREAKFAST
                R.id.radioLunch -> MealTime.LUNCH
                R.id.radioDinner -> MealTime.DINNER
                else -> null
            }

            val keyword = edtSearch.text.toString()

            currentList = foodList.filter { food ->
                (selectedMealTime == null || food.mealTimes.contains(selectedMealTime)) &&
                        food.name.contains(keyword)
            }

            adapter.clear()
            adapter.addAll(currentList.map { it.name })
            adapter.notifyDataSetChanged()
        }

        // 🍽 點擊餐廳 → 詳細 Dialog
        listView.setOnItemClickListener { _, _, position, _ ->
            val food = currentList[position]

            val dialogView = LayoutInflater.from(this)
                .inflate(R.layout.dialog_food_detail, null)

            dialogView.findViewById<ImageView>(R.id.imgFood)
                .setImageResource(food.imageResId)

            dialogView.findViewById<TextView>(R.id.txtFoodName)
                .text = food.name

            dialogView.findViewById<TextView>(R.id.txtFoodAddress)
                .text = food.address

            dialogView.findViewById<TextView>(R.id.txtOpenTime)
                .text = "營業時間：${food.openTime}"

            AlertDialog.Builder(this)
                .setView(dialogView)
                .setPositiveButton("關閉", null)
                .show()
        }
    }
}