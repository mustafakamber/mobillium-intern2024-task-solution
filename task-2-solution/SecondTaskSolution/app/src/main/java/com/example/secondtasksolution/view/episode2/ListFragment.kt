package com.example.secondtasksolution.view.episode2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondtasksolution.R
import com.example.secondtasksolution.adapter.CityAdapter
import com.example.secondtasksolution.databinding.FragmentListBinding
import com.example.secondtasksolution.util.CityDataSource
import com.example.secondtasksolution.util.Constant.CITY_NAME
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_IMAGE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_NAME
import com.example.secondtasksolution.util.Extension.getFragment


class ListFragment : Fragment(R.layout.fragment_list) {

    private var fragmentListBinding: FragmentListBinding? = null
    private var listAdapter = CityAdapter(mutableListOf()) {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentListBinding.bind(view)
        fragmentListBinding = binding

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)

        binding.listFragmentRecyclerView.layoutManager = LinearLayoutManager(context)

        val dataSource = CityDataSource()
        val cities = dataSource.getCities(requireContext())

        listAdapter = CityAdapter(cities) { city ->

            val bundle = Bundle().apply {
                putString(CITY_NAME, city.cityName)
                putString(CITY_WEATHER_NAME, city.cityWeatherName)
                city.cityWeatherImage?.let { putInt(CITY_WEATHER_IMAGE, it) }
                city.cityTemperature?.let { putInt(CITY_TEMPERATURE, it) }
            }

           DetailFragment().getFragment(context as AppCompatActivity,bundle)

        }

        binding.listFragmentRecyclerView.adapter = listAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentListBinding = null
    }

}