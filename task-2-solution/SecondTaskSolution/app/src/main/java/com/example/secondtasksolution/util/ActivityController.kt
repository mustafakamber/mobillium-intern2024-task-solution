package com.example.secondtasksolution.util

import android.app.Activity
import android.content.Intent
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.Constant.CITY_NAME
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_IMAGE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_NAME

object ActivityController {
    fun Activity.navigateToActivityWithExt(destinationActivity: Activity, city: City? = null) {
        val intent = Intent(this, destinationActivity::class.java)
            .apply {
                city?.let {
                    putExtra(CITY_NAME, city.cityName)
                    putExtra(CITY_WEATHER_NAME, city.weatherName)
                    putExtra(CITY_WEATHER_IMAGE, city.weatherImage)
                    putExtra(CITY_TEMPERATURE, city.temperature)
                }
            }
        startActivity(intent)
    }
}
