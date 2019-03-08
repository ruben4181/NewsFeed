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
import com.example.ruben4181.newsfeed.net.ImageLoader

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val display = this.windowManager.defaultDisplay

        val newsRV = findViewById<RecyclerView>(R.id.news_recyclerview)

        newsRV.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        var bitmap : Bitmap = Bitmap.createBitmap(250, 300, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.setColor(Color.RED)
        canvas.drawRect(0F, 0F, 250.toFloat(), 300.toFloat(), paint)

        val news = ArrayList<Noticia>()

        news.add(Noticia("Primer titulo", "Esto es un texto de caracter informativo que en algun momento va a ser tan largo que se va a ver mal en la aplicacion, lo unico es que yo soy un capo y voy a hacer que se vea bien en la aplicacion, putitosssssss asdasdsa sada sd sa",
            "https://jesuitas.co/images/fotos/4806.jpg", bitmap))
        news.add(Noticia("Segundo titulo", "Cada publicacion contara con imagenes distintas","", bitmap))
        news.add(Noticia("Tercer titulo", "Que seran representadas de una base de datos", "", bitmap))
        news.add(Noticia("Cuarto titulo", "Y se podran observar en la aplcacion","", bitmap))
        news.add(Noticia("Quinto titulo", "", "", bitmap))
        news.add(Noticia("Sexto titulo", "", "", bitmap))
        news.add(Noticia("Septimo titulo", "", "", bitmap))
        news.add(Noticia("Octavo titulo", "", "", bitmap))
        news.add(Noticia("Noveno titulo", "","http://caliescribe.com/sites/default/files/imagenes_revista/2016/09/17/javeriana-video/javeriana.jpg", bitmap))
        news.add(Noticia("Decimo titulo", "", "https://jesuitas.co/images/fotos/4806.jpg", bitmap))
        news.add(Noticia("Onceavo titulo", "","", bitmap))
        news.add(Noticia("Doceavo titulo", "","", bitmap))

        val newsAdapter = NewsAdapter(news, display.width)

        newsRV.adapter=newsAdapter
        newsRV.getRecycledViewPool().setMaxRecycledViews(0, 0);


    }
}
