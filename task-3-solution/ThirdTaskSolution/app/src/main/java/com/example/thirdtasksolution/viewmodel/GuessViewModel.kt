package com.example.thirdtasksolution.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessViewModel : ViewModel() {

    private val _randomNumber = MutableLiveData<Int>()

    private val _randomChar = MutableLiveData<Char>()
    val randomChar: LiveData<Char>
        get() = _randomChar

    init {
        generateRandomNumber()
    }

    fun generateRandomNumber() {
        val random = java.util.Random()
        _randomNumber.value = random.nextInt(10)
        _randomChar.value = ('A'..'Z').random()
    }

    fun checkGuess(guess: Int): Boolean {
        val actualNumber = _randomNumber.value ?: return false
        return guess == actualNumber
    }

}