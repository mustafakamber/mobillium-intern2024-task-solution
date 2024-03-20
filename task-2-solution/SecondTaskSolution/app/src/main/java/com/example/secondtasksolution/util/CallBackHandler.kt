package com.example.secondtasksolution.util

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentActivity


object CallBackHandler {

    fun FragmentActivity.onBackPressed(backButtonPressed: () -> Unit) {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backButtonPressed()
            }
        }
        this.onBackPressedDispatcher.addCallback(callback)
    }
}