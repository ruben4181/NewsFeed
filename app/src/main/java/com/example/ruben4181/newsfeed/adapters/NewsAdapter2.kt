package com.example.ruben4181.newsfeed.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.ruben4181.newsfeed.Noticia
import com.example.ruben4181.newsfeed.R
import com.squareup.picasso.Picasso


class NewsAdapter2(val items : ArrayList<Noticia>, val dispWidth : Int) : RecyclerView.Adapter<NewsAdapter2.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v= LayoutInflater.from(p0.context).inflate(R.layout.news_with_cardview, p0, false)
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
        } else{
            p0.newsImage.setImageBitmap(items[p1].resImg)

        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val titleTV = itemView.findViewById<TextView>(R.id.cardview_title)
        val abstTV = itemView.findViewById<TextView>(R.id.cardview_abs)
        val newsImage = itemView.findViewById<ImageView>(R.id.cardview_imageview)
    }
}