package com.example.secondtasksolution.view.episode1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondtasksolution.databinding.ActivityDetailBinding
import com.example.secondtasksolution.util.Constant.CITY_NAME
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE_MAX
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE_MIN
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_IMAGE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_NAME

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cityName = intent.getStringExtra(CITY_NAME)
        val cityWeatherName = intent.getStringExtra(CITY_WEATHER_NAME)
        val cityWeatherImage = intent.getIntExtra(CITY_WEATHER_IMAGE,0)
        val cityTemperature = intent.getIntExtra(CITY_TEMPERATURE,0)
        //val cityTemperatureMin = intent.getIntExtra(CITY_TEMPERATURE_MIN,0)
        //val cityTemperatureMax = intent.getIntExtra(CITY_TEMPERATURE_MAX,0)

        with(binding){

            detailActivityCityText.text = cityName
            detailActivityWeatherImage.setImageResource(cityWeatherImage)
            detailActivityWeatherText.text = cityWeatherName
            detailActivityTemperatureText.text =  cityTemperature.toString()

        }

    }
}