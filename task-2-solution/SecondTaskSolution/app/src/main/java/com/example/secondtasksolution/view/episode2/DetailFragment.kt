package com.example.secondtasksolution.view.episode2

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.secondtasksolution.R
import com.example.secondtasksolution.databinding.FragmentDetailBinding
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.CallBackHandler.onBackPressed
import com.example.secondtasksolution.util.Constant.CITY_DATA
import com.example.secondtasksolution.util.FragmentController.navigateToFragmentWithExt

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
        ListFragment.newInstance().navigateToFragmentWithExt(requireActivity() as AppCompatActivity)
    }
}

