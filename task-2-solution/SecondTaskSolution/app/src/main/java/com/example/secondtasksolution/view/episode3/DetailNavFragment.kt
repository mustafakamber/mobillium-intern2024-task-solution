package com.example.secondtasksolution.view.episode3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.secondtasksolution.R
import com.example.secondtasksolution.databinding.FragmentDetailNavBinding
import com.example.secondtasksolution.util.Constant.CITY_ID
import com.example.secondtasksolution.util.Constant.REQUEST_KEY
import com.example.secondtasksolution.util.Constant.UPDATED_CITY

class DetailNavFragment : Fragment(R.layout.fragment_detail_nav) {

    private var fragmentDetailNavBinding: FragmentDetailNavBinding? = null
    private var currentTemperature = 0
    private val args by navArgs<DetailNavFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailNavBinding.bind(view)
        fragmentDetailNavBinding = binding

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backToListNavFragment()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)

        with(binding) {

            args.currentCity.run {
                detailNavFragmentCityText.text = cityName
                detailNavFragmentWeatherImage.setImageResource(cityWeatherImage)
                detailNavFragmentWeatherText.text = cityWeatherName
                currentTemperature = cityTemperature
                detailNavFragmentTemperatureText.text = currentTemperature.toString()
            }

            detailNavFragmentRefreshImage.setOnClickListener {
                val randomTemperature =
                    (args.currentCity.cityTemperatureMin..args.currentCity.cityTemperatureMax).random()
                currentTemperature = randomTemperature
                detailNavFragmentTemperatureText.text = currentTemperature.toString()
            }

            detailNavFragmentUpdateDataButton.setOnClickListener {

                val updatedWeather = args.currentCity.copy(cityTemperature = currentTemperature)
                setFragmentResult(REQUEST_KEY, Bundle().apply {
                    putParcelable(UPDATED_CITY, updatedWeather)
                    putInt(CITY_ID, args.currentCity.cityId)
                })

                backToListNavFragment()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentDetailNavBinding = null
    }

    private fun backToListNavFragment() {
        findNavController().popBackStack()
    }

}