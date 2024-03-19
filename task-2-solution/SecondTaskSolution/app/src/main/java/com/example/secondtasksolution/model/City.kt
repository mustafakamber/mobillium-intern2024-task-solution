package com.example.secondtasksolution.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val id: Int,
    val cityName: String,
    val weatherName: String,
    val weatherImage: Int,
    var temperature: Int,
    val temperatureMin: Int,
    val temperatureMax: Int
) : Parcelable