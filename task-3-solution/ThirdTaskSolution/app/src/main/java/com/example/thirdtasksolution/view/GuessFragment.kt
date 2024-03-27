package com.example.thirdtasksolution.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentGuessBinding
import com.example.thirdtasksolution.util.CallBackHandler.onBackPressed
import com.example.thirdtasksolution.util.FragmentController.navigateToNewFragment
import com.example.thirdtasksolution.util.FragmentController.navigateToPreviousFragment
import com.example.thirdtasksolution.viewmodel.GuessViewModel
import com.example.thirdtasksolution.viewmodel.SharedViewModel


class GuessFragment : Fragment() {

    private lateinit var binding: FragmentGuessBinding
    private val viewModel: GuessViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBackPressed {
            navigateToPreviousFragment()
        }

        observeLiveData()

        setupGuessScreen()
    }

    private fun setupGuessScreen() = with(binding) {

        val numberButtons = arrayOf(
            oneButton,
            twoButton,
            threeButton,
            fourButton,
            fiveButton,
            sixButton,
            sevenButton,
            eightButton,
            nineButton,
            zeroButton
        )
        for (button in numberButtons) {
            button.setOnClickListener {
                val buttonText = button.text.toString()
                showNumberInput(buttonText)
            }
        }

        guessCharacterText.setOnClickListener {
            val action = GuessFragmentDirections.actionGuessFragmentToDetailFragment()
            navigateToNewFragment(action)
        }

        clearButton.setOnClickListener {
            viewModel.generateRandomNumber()
        }

        guessButton.setOnClickListener {
            val userInput = guessResultText.text.toString()
            viewModel.inputControl(userInput)
        }

    }

    private fun observeLiveData() {

        viewModel.randomChar.observe(viewLifecycleOwner) { randomChar ->
            randomChar?.let {
                binding.guessCharacterText.text = randomChar
            }
        }

        viewModel.randomNumber.observe(viewLifecycleOwner) { randomNumber ->
            randomNumber?.let {
                sharedViewModel.updateHiddenNumber(randomNumber)
            }
        }

        viewModel.gameResultMessage.observe(viewLifecycleOwner) { resultMessage ->
            resultMessage?.let {
                binding.guessResultText.text = getString(resultMessage)
            }
        }
    }

    private fun showNumberInput(numberInput: String) = with(binding) {
        guessResultText.text = numberInput
    }

}