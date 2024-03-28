package com.example.thirdtasksolution.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var counterNumber = MutableLiveData<Int>()

    init {
        counterNumber.postValue(0)
    }

    fun increaseNumber() {
        counterNumber.postValue((counterNumber.value ?: 0) + 1)
    }
}