package com.example.ruben4181.newsfeed

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ruben4181.newsfeed.adapters.HomePagerAdapter

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dispWidth = this.getArguments()?.getString("DISPLAY_WIDTH")

        val homePagerAdapter : HomePagerAdapter = HomePagerAdapter(this.childFragmentManager)
        val bundle = Bundle()
        bundle.putString("DISPLAY_WIDTH", dispWidth)

        val newsFragment = NewsFragment()
        newsFragment.setArguments(bundle)

        homePagerAdapter.addFragment(newsFragment, "Noticias")
        homePagerAdapter.addFragment(NewsFragment(), "Eventos")
        val viewPager : ViewPager = view.findViewById(R.id.home_viewpager)
        viewPager.adapter=homePagerAdapter
        val tabLayout : TabLayout = view.findViewById(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)
    }
}