package com.example.secondtasksolution.util

import android.app.Activity
import android.content.Intent
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.Constant.CITY_DATA

object ActivityController {

    fun Activity.navigateToActivityWithExt(destinationActivity: Activity, city: City? = null) {
        val intent = Intent(this, destinationActivity::class.java)
            .apply {
                city?.let {
                    putExtra(CITY_DATA,city)
                }
            }
        startActivity(intent)
    }
}
