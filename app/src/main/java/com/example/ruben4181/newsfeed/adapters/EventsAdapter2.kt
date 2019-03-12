package com.example.ruben4181.newsfeed.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.ruben4181.newsfeed.Evento
import com.example.ruben4181.newsfeed.R
import com.squareup.picasso.Picasso

class EventsAdapter2(val items : ArrayList<Evento>, val dispWidth : Int) : RecyclerView.Adapter<EventsAdapter2.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): EventsAdapter2.ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.events_with_cardview, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: EventsAdapter2.ViewHolder, p1: Int) {
        p0.titleTV.text = items[p1].titulo
        p0.abstTV.text = items[p1].abst
        if (items[p1].URL != "") {
            Picasso.get().load(items[p1].URL).resize(dispWidth, p0.eventImage.maxHeight).centerCrop().into(p0.eventImage)
        }
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val titleTV = itemView.findViewById<TextView>(R.id.cardview_event_title)
        val abstTV = itemView.findViewById<TextView>(R.id.cardview_event_abs)
        val eventImage = itemView.findViewById<ImageView>(R.id.cardview_event_imageview)
    }
}