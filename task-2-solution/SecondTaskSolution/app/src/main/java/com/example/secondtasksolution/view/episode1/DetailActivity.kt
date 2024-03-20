package com.example.secondtasksolution.view.episode1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondtasksolution.databinding.ActivityDetailBinding
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.Constant.CITY_DATA

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateDetailViewCityDataWithIntent()
    }

    private fun updateDetailViewCityDataWithIntent() = with(binding) {

        val city = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(CITY_DATA,City::class.java)
        } else {
            intent.getParcelableExtra(CITY_DATA)
        }
        city?.let {
            detailActivityCityText.text = city.cityName
            detailActivityWeatherImage.setImageResource(city.weatherImage)
            detailActivityWeatherText.text = city.weatherName
            detailActivityTemperatureText.text = city.temperature.toString()
        }
    }
}