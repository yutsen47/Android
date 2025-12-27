package com.example.afinal
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<Button>(R.id.btnLocation)
            .setOnClickListener { start(LocationActivity::class.java) }

        findViewById<Button>(R.id.btnCampus)
            .setOnClickListener { start(CampusMapActivity::class.java) }

        findViewById<Button>(R.id.btnRoute)
            .setOnClickListener { start(RouteActivity::class.java) }

        findViewById<Button>(R.id.btnWeather)
            .setOnClickListener { start(WeatherActivity::class.java) }
    }

    private fun start(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }
}
