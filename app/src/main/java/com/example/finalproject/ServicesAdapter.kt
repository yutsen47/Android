package com.example.campusguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServicesAdapter(private val services: List<String>) :
    RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtService: TextView = itemView.findViewById(R.id.txtService)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_service, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = services.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtService.text = services[position]
    }
}
