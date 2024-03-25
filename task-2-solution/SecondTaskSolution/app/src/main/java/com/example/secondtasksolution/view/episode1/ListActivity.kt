package com.example.secondtasksolution.view.episode1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondtasksolution.adapter.CityAdapter
import com.example.secondtasksolution.databinding.ActivityListBinding
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.ActivityController.navigateToActivityWithExt
import com.example.secondtasksolution.util.CallBackHandler.onBackPressed
import com.example.secondtasksolution.util.CityDataSource

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private var listAdapter = CityAdapter(mutableListOf()) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackPressed {
            backToMainScreen()
        }

        val data = readDataFromSource()

        showDataInAdapter(data)
    }

    private fun readDataFromSource(): MutableList<City> {
        val cities = CityDataSource().getCities(this)
        return cities
    }

    private fun showDataInAdapter(cities: MutableList<City>) {
        listAdapter = CityAdapter(cities) { city ->
            navigateToDetailScreen(city)
        }
        binding.listActivityRecyclerView.adapter = listAdapter
    }

    private fun navigateToDetailScreen(city: City) {
        navigateToActivityWithExt(DetailActivity(), city)
    }

    private fun backToMainScreen(){
        finish()
    }

}