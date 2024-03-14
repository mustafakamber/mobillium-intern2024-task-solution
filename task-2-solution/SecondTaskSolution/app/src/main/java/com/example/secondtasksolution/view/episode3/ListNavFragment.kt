package com.example.secondtasksolution.view.episode3

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondtasksolution.R
import com.example.secondtasksolution.adapter.CityAdapter
import com.example.secondtasksolution.databinding.FragmentListNavBinding
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.CityDataSource
import com.example.secondtasksolution.util.Constant.CITY_ID
import com.example.secondtasksolution.util.Constant.REQUEST_KEY
import com.example.secondtasksolution.util.Constant.UPDATED_CITY

class ListNavFragment : Fragment(R.layout.fragment_list_nav) {

    private var fragmentListNavBinding: FragmentListNavBinding? = null
    private var listAdapter = CityAdapter(mutableListOf()) {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentListNavBinding.bind(view)
        fragmentListNavBinding = binding

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)

        binding.listNavFragmentRecyclerView.layoutManager = LinearLayoutManager(context)

        val dataSource = CityDataSource()
        val cities = dataSource.getCities(requireContext())

        listAdapter = CityAdapter(cities) { city ->
            goToDetailFragment(city)
        }

        binding.listNavFragmentRecyclerView.adapter = listAdapter

        setFragmentResultListener(REQUEST_KEY) { _, bundle ->

            val updatedWeather = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(UPDATED_CITY,City::class.java)
            } else {
                bundle.getParcelable(UPDATED_CITY)
            }

            val cityId = bundle.getInt(CITY_ID)
            updatedWeather?.let {
                val index = cities.indexOfFirst { city -> city.cityId == cityId }
                if (index != -1) {
                    cities[index] = it
                    listAdapter.notifyItemChanged(index)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentListNavBinding = null
    }

    private fun goToDetailFragment(city: City) {
        findNavController()
            .navigate(ListNavFragmentDirections.actionListNavFragmentToDetailNavFragment(city))
    }

}