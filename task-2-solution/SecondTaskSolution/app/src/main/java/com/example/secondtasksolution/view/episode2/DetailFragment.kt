package com.example.secondtasksolution.view.episode2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.secondtasksolution.R
import com.example.secondtasksolution.databinding.FragmentDetailBinding
import com.example.secondtasksolution.util.Constant.CITY_NAME
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_IMAGE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_NAME
import com.example.secondtasksolution.util.Extension.getFragment

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var fragmentDetailBinding : FragmentDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailBinding.bind(view)
        fragmentDetailBinding = binding

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                ListFragment().getFragment(context as AppCompatActivity)
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)

        val bundle = arguments

        bundle?.run {

            val cityName = getString(CITY_NAME)
            val cityWeatherName = getString(CITY_WEATHER_NAME)
            val cityWeatherImage = getInt(CITY_WEATHER_IMAGE,0)
            val cityTemperature = getInt(CITY_TEMPERATURE,0)

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

}