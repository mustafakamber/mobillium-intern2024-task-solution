package com.example.secondtasksolution.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.secondtasksolution.R

object FragmentController {

    fun Fragment.navigateToFragmentWithExt(activity: AppCompatActivity) {
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentToFragment, this)
        transaction.commit()
    }
}
