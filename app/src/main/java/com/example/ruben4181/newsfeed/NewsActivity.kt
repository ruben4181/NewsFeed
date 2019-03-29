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

class NewsActivity : AppCompatActivity() {
    private lateinit var display : Display
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var ft : FragmentTransaction
    private lateinit var fragment : Fragment
    private val listFragments = ArrayList<Fragment>()

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

        listFragments.add(HomeFragment())
        listFragments.add(SubjectsFragment())
        listFragments.add(EventsFragment())

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val navigationView : NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped

            // Handle navigation view item clicks here.
            displaySelectedScreen(menuItem.itemId)
            drawerLayout.closeDrawers()
            true
        }

        display = this.windowManager.defaultDisplay

        fragment=HomeFragment()
        val bundle = Bundle()
        bundle.putString("DISPLAY_WIDTH", display.width.toString())

        ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
        ft.replace(R.id.content_frame, fragment)
        ft.addToBackStack(null)
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
            fragment = listFragments[0]
            val bundle = Bundle()
            bundle.putString("DISPLAY_WIDTH", display.width.toString())
            fragment.setArguments(bundle)
        }
        if(item==R.id.nav_menu2){
            fragment = listFragments[1]
            val bundle = Bundle()
            bundle.putString("DISPLAY_WIDTH", display.width.toString())
            fragment.setArguments(bundle)
        }
        if(item==R.id.nav_menu3){
            fragment = listFragments[2]
            val bundle = Bundle()
            bundle.putString("DISPLAY_WIDTH", display.width.toString())
            fragment.setArguments(bundle)
        }

        if(fragment!=null){
            ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.content_frame, fragment)
            ft.commit()
        }
    }
}
