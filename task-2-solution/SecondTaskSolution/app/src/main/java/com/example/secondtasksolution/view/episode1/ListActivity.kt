package com.example.secondtasksolution.view.episode1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondtasksolution.adapter.CityAdapter
import com.example.secondtasksolution.databinding.ActivityListBinding
import com.example.secondtasksolution.util.CityDataSource
import com.example.secondtasksolution.util.Extension.getActivity

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private var listAdapter = CityAdapter(mutableListOf()) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        }

        onBackPressedDispatcher.addCallback(callback)

        binding.listActivityRecyclerView.layoutManager = LinearLayoutManager(this)

        val dataSource = CityDataSource()
        val cities = dataSource.getCities(this)

        listAdapter = CityAdapter(cities) { city ->
            getActivity(DetailActivity(),city)
        }

        binding.listActivityRecyclerView.adapter = listAdapter
    }
}