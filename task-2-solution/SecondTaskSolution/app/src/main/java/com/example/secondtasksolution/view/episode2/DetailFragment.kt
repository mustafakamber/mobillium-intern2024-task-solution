package com.example.secondtasksolution.view.episode2

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.secondtasksolution.R
import com.example.secondtasksolution.databinding.FragmentDetailBinding
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.CallBackHandler.onBackPressed
import com.example.secondtasksolution.util.Constant.CITY_DATA

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var fragmentDetailBinding: FragmentDetailBinding

    companion object {
        fun newInstance(bundle: Bundle): DetailFragment {
            val fragment = DetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        fragmentDetailBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressed {
            backToListScreen()
        }

        updateDetailViewCityDataWithBundle()
    }

    private fun updateDetailViewCityDataWithBundle() = with(fragmentDetailBinding) {
        arguments?.let {
            val city = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                arguments?.getParcelable(CITY_DATA, City::class.java)
            } else {
                arguments?.getParcelable(CITY_DATA)
            }
            city?.let {
                detailFragmentCityText.text = city.cityName
                detailFragmentWeatherImage.setImageResource(city.weatherImage)
                detailFragmentWeatherText.text = city.weatherName
                detailFragmentTemperatureText.text = city.temperature.toString()
            }
        }
    }

    private fun backToListScreen() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        fragmentManager.popBackStack()
    }
}

