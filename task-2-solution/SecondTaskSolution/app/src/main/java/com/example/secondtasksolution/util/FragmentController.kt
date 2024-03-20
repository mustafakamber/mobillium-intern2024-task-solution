package com.example.secondtasksolution.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.secondtasksolution.R
import com.example.secondtasksolution.util.Constant.POP_BACK_DATA

object FragmentController {
    fun Fragment.navigateToFragmentWithExt(activity: AppCompatActivity) {
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentToFragment, this)
        transaction.addToBackStack(POP_BACK_DATA)
        transaction.commit()
    }
}
