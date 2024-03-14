package com.example.secondtasksolution.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val cityId: Int,
    val cityName : String,
    val cityWeatherName : String,
    val cityWeatherImage : Int,
    var cityTemperature : Int,
    val cityTemperatureMin : Int,
    val cityTemperatureMax : Int
) : Parcelable