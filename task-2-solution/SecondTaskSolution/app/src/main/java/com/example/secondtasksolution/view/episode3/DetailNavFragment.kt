package com.example.secondtasksolution.view.episode3

import android.health.connect.datatypes.units.Temperature
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.secondtasksolution.R
import com.example.secondtasksolution.databinding.FragmentDetailNavBinding
import com.example.secondtasksolution.util.CallBackHandler
import com.example.secondtasksolution.util.Constant.CITY_ID
import com.example.secondtasksolution.util.Constant.REQUEST_KEY
import com.example.secondtasksolution.util.Constant.UPDATED_CITY

class DetailNavFragment : Fragment(R.layout.fragment_detail_nav) {

    private var fragmentDetailNavBinding: FragmentDetailNavBinding? = null
    private var currentTemperature = 0
    private val args by navArgs<DetailNavFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailNavBinding.inflate(inflater, container, false)
        fragmentDetailNavBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CallBackHandler.handleCallback(requireActivity()) {
            backToListScreen()
        }

        getDataWithArgs { cityName, weatherName, weatherImage, temperature, temperatureMin, temperatureMax ->

            with(fragmentDetailNavBinding!!) {

                detailNavFragmentCityText.text = cityName
                detailNavFragmentWeatherImage.setImageResource(weatherImage)
                detailNavFragmentWeatherText.text = weatherName
                currentTemperature = temperature
                showTemperature(currentTemperature)

                detailNavFragmentRefreshImage.setOnClickListener {
                    currentTemperature = updateTemperature(temperatureMin, temperatureMax)
                    showTemperature(currentTemperature)
                }

                detailNavFragmentUpdateDataButton.setOnClickListener {
                    updateCityData(currentTemperature)
                    backToListScreen()
                }
            }
        }
    }

    private fun getDataWithArgs(dataReady: (String, String, Int, Int, Int, Int) -> Unit) {
        args.currentCity.run {
            dataReady.invoke(
                cityName,
                weatherName,
                weatherImage,
                temperature,
                temperatureMin,
                temperatureMax
            )
        }
    }

    private fun showTemperature(currentTemperature: Int){
        fragmentDetailNavBinding!!.detailNavFragmentTemperatureText.text = currentTemperature.toString()
    }

    private fun updateTemperature(min: Int, max: Int): Int {
        val randomTemperature = (min..max).random()
        return randomTemperature
    }

    private fun updateCityData(currentTemperature : Int){
        val updatedWeather = args.currentCity.copy(temperature = currentTemperature)
        setFragmentResult(REQUEST_KEY, Bundle().apply {
            putParcelable(UPDATED_CITY, updatedWeather)
            putInt(CITY_ID, args.currentCity.id)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentDetailNavBinding = null
    }

    private fun backToListScreen() {
        findNavController().popBackStack()
    }

}