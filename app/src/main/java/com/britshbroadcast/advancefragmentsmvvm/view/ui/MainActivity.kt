package com.britshbroadcast.advancefragmentsmvvm.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.britshbroadcast.advancefragmentsmvvm.R
import com.britshbroadcast.advancefragmentsmvvm.databinding.ActivityMainBinding
import com.britshbroadcast.advancefragmentsmvvm.view.adapter.RadioViewPageAdapter
import com.britshbroadcast.advancefragmentsmvvm.viewmodel.RadioViewModel

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {


    private lateinit var binding: ActivityMainBinding
    private lateinit var radioViewGroupAdapter: FragmentPagerAdapter

    private val radioViewModel by viewModels<RadioViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        radioViewGroupAdapter = RadioViewPageAdapter(supportFragmentManager)
        binding.mainViewpager.adapter = radioViewGroupAdapter

        binding.mainViewpager.addOnPageChangeListener(this)

        binding.mainNavegationview.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.podcast_menu_item -> binding.mainViewpager.currentItem = 0
                R.id.live_menu_item -> binding.mainViewpager.currentItem = 1
                R.id.settings_menu_item -> binding.mainViewpager.currentItem = 2
            }
            true

        }


    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        // DO NOTHING
    }

    override fun onPageSelected(position: Int) {
        // DO NOTHING
    }

    override fun onPageScrollStateChanged(state: Int) {
        binding.mainNavegationview.selectedItemId = when(state){
            0 -> R.id.podcast_menu_item
            1 -> R.id.live_menu_item
            else -> R.id.settings_menu_item
        }
    }
}