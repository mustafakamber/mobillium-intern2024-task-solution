package com.example.secondtasksolution.view.episode3

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondtasksolution.R
import com.example.secondtasksolution.adapter.CityAdapter
import com.example.secondtasksolution.databinding.FragmentListNavBinding
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.CallBackHandler
import com.example.secondtasksolution.util.CityDataSource
import com.example.secondtasksolution.util.Constant.CITY_ID
import com.example.secondtasksolution.util.Constant.REQUEST_KEY
import com.example.secondtasksolution.util.Constant.UPDATED_CITY

class ListNavFragment : Fragment(R.layout.fragment_list_nav) {

    private var fragmentListNavBinding: FragmentListNavBinding? = null
    private var listAdapter = CityAdapter(mutableListOf()) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListNavBinding.inflate(inflater, container, false)
        fragmentListNavBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CallBackHandler.handleCallback(requireActivity()) {
            backToMainScreen()
        }

        val data = getDataFromSource()

        showDataInAdapter(data)

        fragmentResultListener(data)
    }

    private fun getDataFromSource(): MutableList<City> {
        val cities = CityDataSource().getCities(requireContext())
        return cities
    }

    private fun showDataInAdapter(cities: MutableList<City>) {
        fragmentListNavBinding!!.listNavFragmentRecyclerView.layoutManager =
            LinearLayoutManager(context)
        listAdapter = CityAdapter(cities) { city ->
            navigateToDetailScreen(city)
        }
        fragmentListNavBinding!!.listNavFragmentRecyclerView.adapter = listAdapter
    }

    private fun fragmentResultListener(cities: MutableList<City>) {
        setFragmentResultListener(REQUEST_KEY) { _, bundle ->
            val updatedWeather = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(UPDATED_CITY, City::class.java)
            } else {
                bundle.getParcelable(UPDATED_CITY)
            }
            val cityId = bundle.getInt(CITY_ID)
            updatedWeather?.let {
                val index = cities.indexOfFirst { city -> city.id == cityId }
                if (index != -1) {
                    cities[index] = it
                    listAdapter.notifyItemChanged(index)
                }
            }
        }
    }

    private fun backToMainScreen() {
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentListNavBinding = null
    }

    private fun navigateToDetailScreen(city: City) {
        val actionToDetailScreen =
            ListNavFragmentDirections.actionListNavFragmentToDetailNavFragment(city)
        findNavController()
            .navigate(actionToDetailScreen)
    }

}