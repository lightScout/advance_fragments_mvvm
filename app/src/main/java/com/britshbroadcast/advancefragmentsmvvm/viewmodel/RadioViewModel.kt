package com.britshbroadcast.advancefragmentsmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RadioViewModel: ViewModel() {

    val countLiveData: MutableLiveData<Int> = MutableLiveData()


    init{

        Thread{
            // i in 0 until 1000 -> 0 to 999
            // i in 0..1000 -> 0 to 1000
            for(i in 0..1000){
                Thread.sleep(1000)
                countLiveData.postValue(i)

        }


        }.start()

    }

}