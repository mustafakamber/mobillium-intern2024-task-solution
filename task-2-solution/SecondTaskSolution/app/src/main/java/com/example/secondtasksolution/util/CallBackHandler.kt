package com.example.secondtasksolution.util

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentActivity

object CallBackHandler {
    fun handleCallback(activity: FragmentActivity, backButtonPressed: () -> Unit) {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backButtonPressed()
            }
        }
        activity.onBackPressedDispatcher.addCallback(callback)
    }
}