package com.example.ruben4181.newsfeed.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.ruben4181.newsfeed.Horario
import com.example.ruben4181.newsfeed.R


class HorariosAdapter(val context : Context, val items : ArrayList<Horario>) : BaseAdapter(){
    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.timeline_class_date_item, parent, false)

        val dayTV = view.findViewById<TextView>(R.id.day_timetable_lv_tv)
        val hourTV = view.findViewById<TextView>(R.id.hour_timetable_lv_tv)
        val placeTV = view.findViewById<TextView>(R.id.place_timetable_lv_tv)

        dayTV.text=items[position].dia
        hourTV.text=items[position].inicio+" - "+items[position].fin
        placeTV.text=items[position].lugar

        return view
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}