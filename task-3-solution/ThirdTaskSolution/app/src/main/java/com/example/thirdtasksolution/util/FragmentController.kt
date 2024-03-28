package com.example.thirdtasksolution.util

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

object FragmentController {

    fun Fragment.navigateToNewFragment(navDirections: NavDirections) {
        findNavController().navigate(navDirections)
    }

    fun Fragment.navigateToPreviousFragment() {
        findNavController().popBackStack()
    }
}