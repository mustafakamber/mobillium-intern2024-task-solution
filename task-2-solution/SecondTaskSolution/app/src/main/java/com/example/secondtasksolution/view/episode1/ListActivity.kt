package com.example.secondtasksolution.view.episode1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondtasksolution.R
import com.example.secondtasksolution.adapter.CityAdapter
import com.example.secondtasksolution.databinding.ActivityListBinding
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.Constant.CITY_NAME
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_IMAGE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_NAME

class ListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListBinding
    private var listAdapter = CityAdapter(mutableListOf(),{})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            listActivityRecyclerView.layoutManager = LinearLayoutManager(this@ListActivity)

            val city1 = City(
                1, "İstanbul",
                getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            )
            val city2 = City(
                2, "Ankara",
                getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            )
            val city3 = City(
                3, "Erzurum",
                getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            )
            val city4 = City(
                4, "Sakarya",
                getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            )

            val cities = arrayListOf(city1, city2, city3, city4)

            listAdapter = CityAdapter(cities) { city ->

                val intent = Intent(this@ListActivity,DetailActivity::class.java)

                intent
                    .putExtra(CITY_NAME,city.cityName)
                    .putExtra(CITY_WEATHER_NAME,city.cityWeatherName)
                    .putExtra(CITY_WEATHER_IMAGE,city.cityWeatherImage)
                    .putExtra(CITY_TEMPERATURE,city.cityTemperature)

                startActivity(intent)
            }

            listActivityRecyclerView.adapter = listAdapter

        }
    }
}