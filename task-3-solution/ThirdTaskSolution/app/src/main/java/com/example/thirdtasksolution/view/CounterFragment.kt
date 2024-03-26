package com.example.thirdtasksolution.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentCounterBinding
import com.example.thirdtasksolution.util.CallBackHandler.navigateToPreviousFragment
import com.example.thirdtasksolution.util.CallBackHandler.onBackPressed
import com.example.thirdtasksolution.viewmodel.CounterViewModel

class CounterFragment : Fragment() {

    private lateinit var counterFragmentBinding: FragmentCounterBinding
    private val counterViewModel: CounterViewModel by viewModels()
    private var counter: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCounterBinding.inflate(inflater, container, false)
        counterFragmentBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBackPressed {
            navigateToPreviousFragment()
        }

        observeLiveData()

        with(counterFragmentBinding) {
            counterIncreaseButton.setOnClickListener {
                if (counterSwitch.isChecked) {
                    counterViewModel.increaseNumber()
                } else {
                    val updatedCounterNumber = increaseCounterNumber().toString()
                    counterText.text = updatedCounterNumber
                }
            }
        }
    }

    private fun increaseCounterNumber(): Int {
        return ++counter
    }

    private fun observeLiveData() {
        counterViewModel.counterNumber.observe(viewLifecycleOwner) { counterNumberFromViewModel ->
            counterNumberFromViewModel.let {
                counterFragmentBinding.counterText.text = counterNumberFromViewModel.toString()
            }
        }
    }

}