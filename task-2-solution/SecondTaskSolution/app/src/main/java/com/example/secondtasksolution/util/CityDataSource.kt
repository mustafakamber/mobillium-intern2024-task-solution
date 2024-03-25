package com.example.secondtasksolution.util

import android.content.Context
import com.example.secondtasksolution.R
import com.example.secondtasksolution.model.City

class CityDataSource {

    fun getCities(context: Context): MutableList<City> {
        return mutableListOf(
            City(
                id = 1,
                cityName = "İstanbul",
                weatherName = context.getString(R.string.weatherNameText),
                weatherImage = R.drawable.ic_sunny_dark,
                temperature = 26,
                temperatureMin = 14,
                temperatureMax = 27
            ),
            City(
                id = 2,
                cityName = "Ankara",
                weatherName = context.getString(R.string.weatherNameText),
                weatherImage = R.drawable.ic_sunny_dark,
                temperature = 26,
                temperatureMin = 14,
                temperatureMax = 27
            ),
            City(
                id = 3,
                cityName = "Erzurum",
                weatherName = context.getString(R.string.weatherNameText),
                weatherImage = R.drawable.ic_sunny_dark,
                temperature = 26,
                temperatureMin = 14,
                temperatureMax = 27
            ),
            City(
                id = 4,
                cityName = "Sakarya",
                weatherName = context.getString(R.string.weatherNameText),
                weatherImage = R.drawable.ic_sunny_dark,
                temperature = 26,
                temperatureMin = 14,
                temperatureMax = 27
            )
        )
    }
}