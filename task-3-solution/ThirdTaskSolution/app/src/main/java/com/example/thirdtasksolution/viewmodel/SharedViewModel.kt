package com.example.thirdtasksolution.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _hiddenNumber = MutableLiveData<Int>()
    val hiddenNumber: LiveData<Int>
        get() = _hiddenNumber

    fun updateHiddenNumber(number: Int) {
        _hiddenNumber.value = number
    }

}