package com.example.thirdtasksolution.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentCounterBinding
import com.example.thirdtasksolution.viewmodel.CounterViewModel

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding
    private val viewModel: CounterViewModel by viewModels()
    private var counter: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        setupCounterScreen()
    }

    private fun setupCounterScreen() = with(binding) {
        counterIncreaseButton.setOnClickListener {
            if (counterSwitch.isChecked) {
                viewModel.increaseNumber()
            } else {
                val updatedCounterNumber = increaseCounterNumber().toString()
                counterText.text = updatedCounterNumber
            }
        }
    }

    private fun increaseCounterNumber(): Int {
        return ++counter
    }

    private fun observeLiveData() {
        viewModel.counterNumber.observe(viewLifecycleOwner) { counterNumber ->
            counterNumber?.let {
                binding.counterText.text = counterNumber.toString()
            }
        }
    }
}