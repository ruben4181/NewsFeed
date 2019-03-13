package com.example.ruben4181.newsfeed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.Display
import android.view.MenuItem
import android.widget.Toast
import com.example.ruben4181.newsfeed.adapters.HomePagerAdapter

/*

        setContentView(R.layout.activity_news)
        this.getSupportActionBar()?.setElevation(0.toFloat())

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
    */

class NewsActivity : AppCompatActivity() {
    private lateinit var display : Display
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var ft : FragmentTransaction
    private lateinit var fragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_drawer_layout)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        this.setSupportActionBar(toolbar)
        val actionBar : ActionBar? = supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        }

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val navigationView : NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            drawerLayout.closeDrawers()

            // Handle navigation view item clicks here.
            displaySelectedScreen(menuItem.itemId)

            true
        }

        display = this.windowManager.defaultDisplay

        fragment=HomeFragment()
        val bundle = Bundle()
        bundle.putString("DISPLAY_WIDTH", display.width.toString())

        ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.content_frame, fragment)
        ft.commit()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun displaySelectedScreen(item : Int){

        if(item==R.id.nav_menu1){
            fragment = HomeFragment()
            val bundle = Bundle()
            bundle.putString("DISPLAY_WIDTH", display.width.toString())
            fragment.setArguments(bundle)
        }
        if(item==R.id.nav_menu2){
            fragment = NewsFragment()
            val bundle = Bundle()
            bundle.putString("DISPLAY_WIDTH", display.width.toString())
            fragment.setArguments(bundle)
        }
        if(item==R.id.nav_menu3){
            fragment = NewsFragment()
            val bundle = Bundle()
            bundle.putString("DISPLAY_WIDTH", display.width.toString())
            fragment.setArguments(bundle)
        }

        if(fragment!=null){
            ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.content_frame, fragment)
            ft.commit()
        }

        drawerLayout.closeDrawer(GravityCompat.START)
    }
}
