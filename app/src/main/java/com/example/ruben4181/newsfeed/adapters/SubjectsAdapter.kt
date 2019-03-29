package com.example.ruben4181.newsfeed.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.ruben4181.newsfeed.R
import com.example.ruben4181.newsfeed.Subject

class SubjectsAdapter(val context : Context, val items : ArrayList<Subject>) : BaseAdapter(){
    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.timetable_list_item, parent,false)
        val subjectNameTV = view.findViewById<TextView>(R.id.subject_name_tv)
        val teachersTV = view.findViewById<TextView>(R.id.subject_teachers_tv)
        val horariosLV = view.findViewById<ListView>(R.id.subject_horarios_lv)

        subjectNameTV.text=items[position].nombre
        var profesores = ""
        for (prof : String in items[position].profesores){
            profesores+=prof+" "
        }

        teachersTV.text=profesores

        val horariosAdapter = HorariosAdapter(context, items[position].horarios)

        horariosLV.adapter=horariosAdapter

        val layoutParams = horariosLV.layoutParams
        val factor = context.resources.displayMetrics.density
        layoutParams.height = (36*factor).toInt()*horariosLV.count
        horariosLV.layoutParams=layoutParams
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