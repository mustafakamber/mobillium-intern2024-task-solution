package com.example.secondtasksolution.util

import android.content.Context
import com.example.secondtasksolution.R
import com.example.secondtasksolution.model.City

class CityDataSource {
    fun getCities(context : Context): MutableList<City> {
        return mutableListOf(
            City(
                1, "İstanbul",
                context.getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            ),
            City(
                2, "Ankara",
                context.getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            ),
            City(
                3, "Erzurum",
                context.getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            ),
            City(
                4, "Sakarya",
                context.getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            )
        )
    }
}