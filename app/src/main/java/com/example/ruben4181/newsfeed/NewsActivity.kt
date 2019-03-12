package com.example.ruben4181.newsfeed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.widget.Toast
import com.example.ruben4181.newsfeed.adapters.HomePagerAdapter


class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val display = this.windowManager.defaultDisplay
        val homePagerAdapter : HomePagerAdapter = HomePagerAdapter(supportFragmentManager)

        //Crear el fragment con las dimensiones necesarias
        val bundle = Bundle()
        bundle.putString("DISPLAY_WIDTH", display.width.toString())


        val newsFragment = NewsFragment()
        newsFragment.setArguments(bundle)

        homePagerAdapter.addFragment(newsFragment, "Noticias")
        homePagerAdapter.addFragment(NewsFragment(), "Eventos")
        val viewPager : ViewPager = findViewById(R.id.home_viewpager)
        viewPager.adapter=homePagerAdapter
        val tabLayout : TabLayout = findViewById(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)
    }
}
