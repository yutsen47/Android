package com.example.afinal

data class Food(
    val name: String,
    val mealTimes: List<MealTime>,
    val address: String,
    val openTime: String,
    val imageResId: Int
)