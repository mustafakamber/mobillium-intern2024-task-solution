package com.example.secondtasksolution.view.episode2

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.secondtasksolution.R
import com.example.secondtasksolution.adapter.CityAdapter
import com.example.secondtasksolution.databinding.FragmentListBinding
import com.example.secondtasksolution.model.City
import com.example.secondtasksolution.util.CallBackHandler.onBackPressed
import com.example.secondtasksolution.util.CityDataSource
import com.example.secondtasksolution.util.Constant.CITY_DATA
import com.example.secondtasksolution.util.FragmentController.navigateToFragmentWithExt

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var fragmentListBinding: FragmentListBinding
    private var listAdapter = CityAdapter(mutableListOf()) {}

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentListBinding.inflate(inflater, container, false)
        fragmentListBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressed {
            backToMainScreen()
        }

        val data = readDataFromSource()

        showDataInAdapter(data)
    }

    private fun readDataFromSource(): MutableList<City> {
        val cities = CityDataSource().getCities(requireContext())
        return cities
    }

    private fun showDataInAdapter(cities: MutableList<City>) {
        listAdapter = CityAdapter(cities) { city ->
            navigateToDetailScreen(city)
        }
        fragmentListBinding.listFragmentRecyclerView.adapter = listAdapter
    }

    private fun navigateToDetailScreen(city: City) {
        val bundle = Bundle().apply {
            putParcelable(CITY_DATA, city)
        }
        DetailFragment.newInstance(bundle)
            .navigateToFragmentWithExt(requireActivity() as AppCompatActivity)
    }

    private fun backToMainScreen() {
        requireActivity().finish()
    }
}