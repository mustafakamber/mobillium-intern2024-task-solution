package com.example.secondtasksolution.view.episode2

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.secondtasksolution.R
import com.example.secondtasksolution.databinding.FragmentDetailBinding
import com.example.secondtasksolution.util.CallBackHandler
import com.example.secondtasksolution.util.Constant.CITY_NAME
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_IMAGE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_NAME
import com.example.secondtasksolution.util.FragmentController.navigateToFragmentWithExt

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var fragmentDetailBinding : FragmentDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        fragmentDetailBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        CallBackHandler.handleCallback(requireActivity()) {
            backToListScreen()
        }

        getDataWithArguments { cityName, weatherName, weatherImage, temperature ->
            with(fragmentDetailBinding!!){
                detailFragmentCityText.text = cityName
                detailFragmentWeatherImage.setImageResource(weatherImage)
                detailFragmentWeatherText.text = weatherName
                detailFragmentTemperatureText.text =  temperature.toString()
            }
        }
    }

    private fun getDataWithArguments(dataReady : (String, String, Int, Int) -> Unit){
        arguments?.apply {
            val cityName = getString(CITY_NAME)
            val cityWeatherName = getString(CITY_WEATHER_NAME)
            val cityWeatherImage = getInt(CITY_WEATHER_IMAGE,0)
            val cityTemperature = getInt(CITY_TEMPERATURE,0)
            dataReady.invoke(cityName!!,cityWeatherName!!,cityWeatherImage,cityTemperature)
        }
    }

    private fun backToListScreen(){
        val listFragment = ListFragment()
        listFragment.navigateToFragmentWithExt(context as AppCompatActivity)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentDetailBinding = null
    }

}