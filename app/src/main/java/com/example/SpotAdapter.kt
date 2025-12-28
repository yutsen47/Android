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

class SpotAdapter(private val context: Context, private val spots: List<Spot>) : BaseAdapter() {
    override fun getCount(): Int = spots.size
    override fun getItem(position: Int): Any = spots[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_spot, parent, false)
        val spot = spots[position]

        val imgSpot = view.findViewById<ImageView>(R.id.imgSpot)
        val txtSpotName = view.findViewById<TextView>(R.id.txtSpotName)
        val txtSpotAddress = view.findViewById<TextView>(R.id.txtSpotAddress)

        imgSpot.setImageResource(spot.imageResId)
        txtSpotName.text = spot.name
        txtSpotAddress.text = spot.address

        return view
    }
}
