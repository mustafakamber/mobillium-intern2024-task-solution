package com.example.thirdtasksolution.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import java.util.Random

class GuessViewModel : ViewModel() {

    private val random = Random()

    private val _randomNumber = MutableLiveData<Int>()
    val randomNumber : LiveData<Int>
        get() = _randomNumber

    private val _gameResultMessage = MutableLiveData<Int>()
    val gameResultMessage: LiveData<Int>
        get() = _gameResultMessage

    private val _randomChar = MutableLiveData<String>()
    val randomChar: LiveData<String>
        get() = _randomChar

    init {
        generateRandomNumber()
    }

    fun generateRandomNumber() {
        _randomNumber.postValue(random.nextInt(10))
        _randomChar.postValue(('A'..'Z').random().toString())
        _gameResultMessage.postValue(R.string.result_fail)
    }

    fun inputControl(userInput: String) {
        val isInteger = userInput.toIntOrNull() != null
        if (isInteger) {
            val guessNumber = userInput.toInt()
            gameResult(guessNumber)
        } else {
            _gameResultMessage.postValue(R.string.result_invalid_input)
        }
    }

    private fun checkGuess(guess: Int): Boolean {
        val actualNumber = _randomNumber.value ?: return false
        return guess == actualNumber
    }

    private fun gameResult(guessNumber: Int?) {
        guessNumber?.let {
            val isEqual = checkGuess(guessNumber)
            if (isEqual) {
                _gameResultMessage.postValue(R.string.result_success)
            } else {
                _gameResultMessage.postValue(R.string.result_fail)
            }
        }
    }

}