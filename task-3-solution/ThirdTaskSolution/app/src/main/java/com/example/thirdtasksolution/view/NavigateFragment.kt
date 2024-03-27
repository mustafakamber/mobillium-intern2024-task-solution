package com.example.thirdtasksolution.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import com.example.myapplication.databinding.FragmentNavigateBinding
import com.example.thirdtasksolution.util.FragmentController.navigateToNewFragment

class NavigateFragment : Fragment() {

    private lateinit var binding: FragmentNavigateBinding
    private lateinit var action : NavDirections

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
            action = NavigateFragmentDirections.actionNavigateFragmentToCounterFragment()
            navigateToNewFragment(action)
        }

        navigateGuessButton.setOnClickListener {
            action = NavigateFragmentDirections.actionNavigateFragmentToGuessFragment()
            navigateToNewFragment(action)
        }
    }

}