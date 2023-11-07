package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.recyclerview.widget.Recyclerview
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.text.FieldPosition


class CalendarAdapter : Recyclerview.Adapter<CalendarAdapter.ItemView>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_day,parent, false)
        return ItemView(view)
    }

    override fun onBindViewHolder(holder: ItemView, position: Int) {
        holder.textDay.setText("1")
    }
    override fun getItemCount(): Int{
        return 7
    }

    class ItemView(view: View) : RecyclerView.ViewHolder(view){
        val textDay: TextView = view.findViewById<TextView>(R.id.text_day)
    }
}