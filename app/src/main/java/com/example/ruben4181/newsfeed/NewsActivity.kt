package com.example.ruben4181.newsfeed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.LinearLayout
import com.example.ruben4181.newsfeed.adapters.NewsAdapter

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRV = findViewById<RecyclerView>(R.id.news_recyclerview)

        newsRV.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val news = ArrayList<Noticia>()

        news.add(Noticia("Primer titulo", ""))
        news.add(Noticia("Primer titulo", ""))
        news.add(Noticia("Primer titulo", ""))
        news.add(Noticia("Primer titulo", ""))
        news.add(Noticia("Primer titulo", ""))
        news.add(Noticia("Primer titulo", ""))
        news.add(Noticia("Primer titulo", ""))
        news.add(Noticia("Primer titulo", ""))
        news.add(Noticia("Primer titulo", ""))
        news.add(Noticia("Primer titulo", ""))
        news.add(Noticia("Primer titulo", ""))
        news.add(Noticia("Primer titulo", ""))

        val newsAdapter = NewsAdapter(news)

        newsRV.adapter=newsAdapter
        runAnimation(newsRV, 0)
    }
    fun runAnimation(rv : RecyclerView, type : Int){
        val controller = AnimationUtils.loadAnimation(rv.context, R.anim.animation_1)
        rv.startAnimation(controller)
        rv.adapter!!.notifyDataSetChanged()

    }
}
