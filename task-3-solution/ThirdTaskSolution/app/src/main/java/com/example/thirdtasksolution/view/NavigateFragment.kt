package com.example.thirdtasksolution.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentNavigateBinding

class NavigateFragment : Fragment() {

    private lateinit var navigateFragmentBinding: FragmentNavigateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNavigateBinding.inflate(inflater, container, false)
        navigateFragmentBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =
        with(navigateFragmentBinding) {
            super.onViewCreated(view, savedInstanceState)

            navigateCounterButton.setOnClickListener {
                navigateFragment(NavigateFragmentDirections.actionNavigateFragmentToCounterFragment())
            }

            navigateGuessButton.setOnClickListener {
                navigateFragment(NavigateFragmentDirections.actionNavigateFragmentToGuessFragment())
            }

        }

    private fun navigateFragment(navDirection: NavDirections) {
        findNavController().navigate(navDirection)
    }

}