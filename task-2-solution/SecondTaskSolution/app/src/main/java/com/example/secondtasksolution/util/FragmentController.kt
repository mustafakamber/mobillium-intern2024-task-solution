package com.example.secondtasksolution.util

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.secondtasksolution.R

object FragmentController {
    fun Fragment.navigateToFragmentWithExt(appCompatActivity: AppCompatActivity, bundle: Bundle? = null) {
        val fragmentManager: FragmentManager = appCompatActivity.supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        bundle?.let {
            arguments = bundle
        }
        transaction.replace(R.id.fragmentToFragment, this)
        transaction.commit()
    }
}