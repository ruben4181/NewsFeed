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

        news.add(Noticia("Primer titulo", "Esto es un texto de caracter informativo que en algun momento va a ser tan largo que se va a ver mal en la aplicacion, lo unico es que yo soy un capo y voy a hacer que se vea bien en la aplicacion, putitosssssss asdasdsa sada sd sa"))
        news.add(Noticia("Segundo titulo", "Cada publicacion contara con imagenes distintas"))
        news.add(Noticia("Tercer titulo", "Que seran representadas de una base de datos"))
        news.add(Noticia("Cuarto titulo", "Y se podran observar en la aplcacion"))
        news.add(Noticia("Quinto titulo", ""))
        news.add(Noticia("Sexto titulo", ""))
        news.add(Noticia("Septimo titulo", ""))
        news.add(Noticia("Octavo titulo", ""))
        news.add(Noticia("Noveno titulo", ""))
        news.add(Noticia("Decimo titulo", ""))
        news.add(Noticia("Onceavo titulo", ""))
        news.add(Noticia("Doceavo titulo", ""))

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
