package com.example.secondtasksolution.view.episode2

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondtasksolution.R
import com.example.secondtasksolution.adapter.CityAdapter
import com.example.secondtasksolution.databinding.FragmentListBinding
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.CallBackHandler
import com.example.secondtasksolution.util.CityDataSource
import com.example.secondtasksolution.util.Constant.CITY_NAME
import com.example.secondtasksolution.util.Constant.CITY_TEMPERATURE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_IMAGE
import com.example.secondtasksolution.util.Constant.CITY_WEATHER_NAME
import com.example.secondtasksolution.util.FragmentController.navigateToFragmentWithExt


class ListFragment : Fragment(R.layout.fragment_list) {

    private var fragmentListBinding: FragmentListBinding? = null
    private var listAdapter = CityAdapter(mutableListOf()) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater, container, false)
        fragmentListBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        CallBackHandler.handleCallback(requireActivity()) {
            navigateToMainScreen()
        }

        val data = readDataFromSource()

        showDataInAdapter(data)
    }

    private fun readDataFromSource(): MutableList<City> {
        val cities = CityDataSource().getCities(requireContext())
        return cities
    }

    private fun showDataInAdapter(cities: MutableList<City>) {
        fragmentListBinding!!.listFragmentRecyclerView.layoutManager =
            LinearLayoutManager(context)
        listAdapter = CityAdapter(cities) { city ->
            navigateToDetailScreen(city)
        }
        fragmentListBinding!!.listFragmentRecyclerView.adapter = listAdapter
    }

    private fun navigateToDetailScreen(city: City) {
        val bundle = Bundle().apply {
            putString(CITY_NAME, city.cityName)
            putString(CITY_WEATHER_NAME, city.weatherName)
            putInt(CITY_WEATHER_IMAGE, city.weatherImage)
            putInt(CITY_TEMPERATURE, city.temperature)
        }
        DetailFragment().navigateToFragmentWithExt(context as AppCompatActivity, bundle)
    }

    private fun navigateToMainScreen() {
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentListBinding = null
    }

}