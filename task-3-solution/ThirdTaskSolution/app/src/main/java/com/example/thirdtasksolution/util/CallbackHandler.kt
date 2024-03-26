package com.example.thirdtasksolution.util

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

object CallBackHandler {

    fun Fragment.onBackPressed(backButtonPressed: () -> Unit) {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backButtonPressed()
            }
        }
        this.requireActivity().onBackPressedDispatcher.addCallback(callback)
    }
    
    fun Fragment.navigateToPreviousFragment(){
        findNavController().popBackStack()
    }
}