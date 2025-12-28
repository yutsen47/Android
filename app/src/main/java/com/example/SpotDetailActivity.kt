package com.example.afinal

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.afinal.Spot
import com.example.afinal.R


class SpotDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spot) // 使用你原本的 activity_main.xml

        // 範例景點資料
        val spots = listOf(
            Spot("景點A", "地址A", R.drawable.school1),
            Spot("景點B", "地址B", R.drawable.school2),
            Spot("景點C", "地址C", R.drawable.school3)
        )

        val listView = findViewById<ListView>(R.id.listViewSpots)

        // 用簡單 ArrayAdapter 只顯示景點名稱
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, spots.map { it.name })
        listView.adapter = adapter

        // 點擊事件 → 顯示 Dialog
        listView.setOnItemClickListener { _, _, position, _ ->
            val spot = spots[position]

            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_spot_detail, null)
            val imgSpot = dialogView.findViewById<ImageView>(R.id.imgSpotDialog)
            val txtName = dialogView.findViewById<TextView>(R.id.txtSpotNameDialog)
            val txtAddress = dialogView.findViewById<TextView>(R.id.txtSpotAddressDialog)

            imgSpot.setImageResource(spot.imageResId)
            txtName.text = spot.name
            txtAddress.text = spot.address

            AlertDialog.Builder(this)
                .setView(dialogView)
                .setPositiveButton("關閉", null)
                .show()
        }
    }
}
