package com.example.secondtasksolution.view.episode1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondtasksolution.databinding.ActivityDetailBinding
import com.example.secondtasksolution.util.Constant.CITY_NAME
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_IMAGE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_NAME

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataWithIntent { cityName, weatherName, weatherImage, temperature ->

            with(binding) {
                detailActivityCityText.text = cityName
                detailActivityWeatherImage.setImageResource(weatherImage)
                detailActivityWeatherText.text = weatherName
                detailActivityTemperatureText.text = temperature.toString()
            }
        }
    }

    private fun getDataWithIntent(dataReady: (String, String, Int, Int) -> Unit) {
        intent.apply {
            val cityName = getStringExtra(CITY_NAME)
            val cityWeatherName = getStringExtra(CITY_WEATHER_NAME)
            val cityWeatherImage = getIntExtra(CITY_WEATHER_IMAGE, 0)
            val cityTemperature = getIntExtra(CITY_TEMPERATURE, 0)

            dataReady.invoke(cityName!!, cityWeatherName!!, cityWeatherImage, cityTemperature)
        }
    }
}