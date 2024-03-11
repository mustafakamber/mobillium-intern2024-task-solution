package com.example.secondtasksolution.view.episode2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondtasksolution.R
import com.example.secondtasksolution.adapter.CityAdapter
import com.example.secondtasksolution.databinding.FragmentListBinding
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.Constant.CITY_NAME
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_IMAGE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_NAME


class ListFragment : Fragment(R.layout.fragment_list) {

    private var fragmentListBinding: FragmentListBinding? = null
    private var listAdapter = CityAdapter(mutableListOf(), {})

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =
        with(fragmentListBinding) {
            super.onViewCreated(view, savedInstanceState)

            val binding = FragmentListBinding.bind(view)
            fragmentListBinding = binding

            binding.listFragmentRecyclerView.layoutManager = LinearLayoutManager(requireContext())

            val city1 = City(
                1, "İstanbul",
                getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            )
            val city2 = City(
                2, "Ankara",
                getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            )
            val city3 = City(
                3, "Erzurum",
                getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            )
            val city4 = City(
                4, "Sakarya",
                getString(R.string.weatherNameText), R.drawable.ic_sunny_dark,
                26, 14, 27
            )

            val cities = arrayListOf(city1, city2, city3, city4)

            listAdapter = CityAdapter(cities) { city ->

                val bundle = Bundle().apply {
                    putString(CITY_NAME, city.cityName)
                    putString(CITY_WEATHER_NAME, city.cityWeatherName)
                    city.cityWeatherImage?.let { putInt(CITY_WEATHER_IMAGE, it) }
                    city.cityTemperature?.let { putInt(CITY_TEMPERATURE, it) }
                }

                goToDetailFragment(bundle)

            }

            binding.listFragmentRecyclerView.adapter = listAdapter


        }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentListBinding = null
    }

    private fun goToDetailFragment(bundle: Bundle) {

        val fragment = DetailFragment()
        fragment.arguments = bundle
        val fragmentManager = (requireContext() as AppCompatActivity).supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.fragmentToFragment, fragment).commit()
        }

    }


}