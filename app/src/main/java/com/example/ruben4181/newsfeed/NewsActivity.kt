package com.example.ruben4181.newsfeed

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.LinearLayout
import com.example.ruben4181.newsfeed.adapters.NewsAdapter
import com.example.ruben4181.newsfeed.adapters.NewsAdapter2
import com.example.ruben4181.newsfeed.net.ImageLoader

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val display = this.windowManager.defaultDisplay

        val newsRV = findViewById<RecyclerView>(R.id.news_recyclerview)

        newsRV.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        var bitmap : Bitmap = Bitmap.createBitmap(display.width, display.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.setColor(Color.RED)
        canvas.drawRect(0F, 0F, 250.toFloat(), 300.toFloat(), paint)

        val news = ArrayList<Noticia>()

        news.add(Noticia("La Pontificia Universidad Javeriana y su compromiso con la paz en Colombia",
            "Esto es un texto de caracter informativo que en algun momento va a ser tan largo que se va a ver mal en la aplicacion, voy a hacer que se vea bien en la aplicacion, putitosssssss asdasdsa sada sd sa",
            "https://jesuitas.co/images/fotos/4806.jpg", bitmap))
        news.add(Noticia("Noveno titulo", "","http://caliescribe.com/sites/default/files/imagenes_revista/2016/09/17/javeriana-video/javeriana.jpg", bitmap))
        news.add(Noticia("Decimo titulo", "", "https://jesuitas.co/images/fotos/4806.jpg", bitmap))
        news.add(Noticia("Onceavo titulo", "","", bitmap))
        news.add(Noticia("Doceavo titulo", "","", bitmap))

        val newsAdapter = NewsAdapter2(news, display.width)

        newsRV.adapter=newsAdapter
        newsRV.getRecycledViewPool().setMaxRecycledViews(0, 0);


    }
}
