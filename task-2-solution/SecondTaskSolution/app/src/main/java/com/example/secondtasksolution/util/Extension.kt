package com.example.secondtasksolution.util

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.secondtasksolution.R
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.Constant.CITY_NAME
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_IMAGE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_NAME

object Extension {

    fun Fragment.getFragment(appCompatActivity: AppCompatActivity, bundle: Bundle? = null) {

        val fragmentManager: FragmentManager = appCompatActivity.supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()

        bundle?.let {
            arguments = bundle
        }

        transaction.replace(R.id.fragmentToFragment, this)
        transaction.commit()
    }

    fun Activity.getActivity(destinationActivity: Activity,city : City? = null){

        val intent = Intent(this,destinationActivity::class.java)
            .apply {
                city?.let {
                    putExtra(CITY_NAME, city.cityName)
                    putExtra(CITY_WEATHER_NAME, city.cityWeatherName)
                    putExtra(CITY_WEATHER_IMAGE, city.cityWeatherImage)
                    putExtra(CITY_TEMPERATURE, city.cityTemperature)
                }
            }

        startActivity(intent)
    }
}