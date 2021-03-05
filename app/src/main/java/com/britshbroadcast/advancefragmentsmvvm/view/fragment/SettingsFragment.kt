package com.britshbroadcast.advancefragmentsmvvm.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.britshbroadcast.advancefragmentsmvvm.R
import com.britshbroadcast.advancefragmentsmvvm.viewmodel.RadioViewModel
import kotlinx.android.synthetic.main.setting_fragment_layout.*

class SettingsFragment: Fragment() {
    private val radioViewModel by activityViewModels<RadioViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.setting_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        radioViewModel.countLiveData.observe(viewLifecycleOwner, Observer {
            settings_main_textview.text = "Live Count at: $it"
        })
    }
}