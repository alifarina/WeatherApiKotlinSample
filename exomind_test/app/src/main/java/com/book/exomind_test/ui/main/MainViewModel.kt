package com.book.exomind_test.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val clickstate = MutableLiveData<Boolean>()

    fun clickStart() {
        clickstate.postValue(true)
    }
}