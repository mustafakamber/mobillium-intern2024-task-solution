package com.example.thirdtasksolution.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var counterNumber = MutableLiveData<Int>()

    init {
        counterNumber.value = 0
    }

    fun increaseNumber() {
        counterNumber.value = (counterNumber.value ?: 0) + 1
    }
}