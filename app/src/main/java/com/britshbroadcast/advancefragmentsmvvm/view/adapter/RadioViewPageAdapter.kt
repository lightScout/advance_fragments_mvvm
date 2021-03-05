package com.britshbroadcast.advancefragmentsmvvm.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.britshbroadcast.advancefragmentsmvvm.view.fragment.LiveFragment
import com.britshbroadcast.advancefragmentsmvvm.view.fragment.PodcastFragment
import com.britshbroadcast.advancefragmentsmvvm.view.fragment.SettingsFragment

class RadioViewPageAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object{
        val FRAGMENT_COUNT = 3
    }

    override fun getCount(): Int = FRAGMENT_COUNT

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> PodcastFragment()
            1 -> LiveFragment()
            else -> SettingsFragment()
        }
    }
}