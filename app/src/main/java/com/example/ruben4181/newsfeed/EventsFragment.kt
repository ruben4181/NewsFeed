package com.example.ruben4181.newsfeed


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.ruben4181.newsfeed.adapters.NewsAdapter2


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class EventsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dispWidth = this.getArguments()?.getString("DISPLAY_WIDTH")?.toInt()

        var width=720
        if (dispWidth!=null){
            width=dispWidth
        }

        val news = ArrayList<Noticia>()
        news.add(Noticia("¿Que ha pasado con la Ingenieria Civil en Colombia?", "Un resumen de lo que ha sucedido en el pais en los ultimos años en este campo",
            "https://www.javerianacali.edu.co/sites/ujc/files/new/p-3036_noticia_becas_doct.jpg"))
        news.add(
            Noticia("Menos de la mitad del control politico se debate en el Concejo de Cali", "El observatorio Cali Visible de Javeriana Cali presenta un balance anual de la gestion de la corporacion municipal",
            "https://www.javerianacali.edu.co/sites/ujc/files/new/banner-pag-web-jave-1.jpg")
        )
        news.add(Noticia("Unete a la semana Pi", "La semana en que los matematicos celebran su día con un monton de actividades",
            "https://www.javerianacali.edu.co/sites/ujc/files/new/semana-pi-810x350.png"))
        val newsRV = view.findViewById<RecyclerView>(R.id.news_fragment_rv)
        newsRV.layoutManager = LinearLayoutManager(view.context, LinearLayout.VERTICAL, false)
        val newsAdapter = NewsAdapter2(news, width)
        newsRV.adapter=newsAdapter
        newsRV.getRecycledViewPool().setMaxRecycledViews(0, 0);
    }
}
