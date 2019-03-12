package com.example.ruben4181.newsfeed.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.ruben4181.newsfeed.Noticia
import com.example.ruben4181.newsfeed.R
import com.squareup.picasso.Picasso

class NewsAdapter(val items : ArrayList<Noticia>, val dispWidth : Int) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.titleTV.text = items[p1].titulo
        p0.abstTV.text = items[p1].abst
        if (items[p1].URL != "") {
            Picasso.get().load(items[p1].URL).resize(dispWidth, p0.newsImage.maxHeight).centerCrop().into(p0.newsImage)
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val titleTV = itemView.findViewById<TextView>(R.id.card_news_title)
        val abstTV = itemView.findViewById<TextView>(R.id.card_new_abs)
        val newsImage = itemView.findViewById<ImageView>(R.id.new_imageview)
    }
}
