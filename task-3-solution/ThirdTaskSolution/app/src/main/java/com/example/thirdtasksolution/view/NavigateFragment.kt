package com.example.thirdtasksolution.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentNavigateBinding

class NavigateFragment : Fragment() {

    private lateinit var binding: FragmentNavigateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNavigateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigateScreen()
    }

    private fun setupNavigateScreen() = with(binding) {
        navigateCounterButton.setOnClickListener {
            val action = NavigateFragmentDirections.actionNavigateFragmentToCounterFragment()
            findNavController().navigate(action)
        }

        navigateGuessButton.setOnClickListener {
            val action = NavigateFragmentDirections.actionNavigateFragmentToGuessFragment()
            findNavController().navigate(action)
        }
    }
}