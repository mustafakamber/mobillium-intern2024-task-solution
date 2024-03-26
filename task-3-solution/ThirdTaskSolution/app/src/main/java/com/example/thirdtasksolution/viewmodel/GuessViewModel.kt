package com.example.thirdtasksolution.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessViewModel : ViewModel() {

    val randomNumber = MutableLiveData<Int>()

    val randomChar = MutableLiveData<Char>()

    init {
        generateRandomNumber()
    }

    fun generateRandomNumber() {
        val random = java.util.Random()
        randomNumber.value = random.nextInt(10)
        randomChar.value = ('A'..'Z').random()
    }

    fun checkGuess(guess: Int): Boolean {
        val actualNumber = randomNumber.value ?: return false
        return guess == actualNumber
    }

}