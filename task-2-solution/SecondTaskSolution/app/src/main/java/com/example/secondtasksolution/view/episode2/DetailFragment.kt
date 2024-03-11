package com.example.secondtasksolution.view.episode2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.secondtasksolution.R
import com.example.secondtasksolution.databinding.FragmentDetailBinding
import com.example.secondtasksolution.util.Constant.CITY_NAME
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_IMAGE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_NAME


class DetailFragment : Fragment(R.layout.fragment_detail) {

   private var fragmentDetailBinding : FragmentDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(fragmentDetailBinding) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailBinding.bind(view)
        fragmentDetailBinding = binding

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backToListFragment()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)

        val bundle = arguments
        if (bundle != null) {

            val cityName = bundle.getString(CITY_NAME)
            val cityWeatherName = bundle.getString(CITY_WEATHER_NAME)
            val cityWeatherImage = bundle.getInt(CITY_WEATHER_IMAGE,0)
            val cityTemperature = bundle.getInt(CITY_TEMPERATURE,0)

            with(binding){
                detailFragmentCityText.text = cityName
                detailFragmentWeatherImage.setImageResource(cityWeatherImage)
                detailFragmentWeatherText.text = cityWeatherName
                detailFragmentTemperatureText.text =  cityTemperature.toString()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentDetailBinding = null
    }

    private fun backToListFragment(){

        val fragment = ListFragment()
        val fragmentManager = (requireContext() as AppCompatActivity).supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.fragmentToFragment, fragment).commit()
        }

    }

}