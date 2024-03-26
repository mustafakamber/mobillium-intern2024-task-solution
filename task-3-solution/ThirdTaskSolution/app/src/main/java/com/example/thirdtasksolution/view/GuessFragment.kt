package com.example.thirdtasksolution.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentGuessBinding
import com.example.thirdtasksolution.util.CallBackHandler.navigateToPreviousFragment
import com.example.thirdtasksolution.util.CallBackHandler.onBackPressed
import com.example.thirdtasksolution.viewmodel.GuessViewModel


class GuessFragment : Fragment() {

    private lateinit var guessFragmentBinding: FragmentGuessBinding
    private val guessViewModel: GuessViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGuessBinding.inflate(inflater, container, false)
        guessFragmentBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBackPressed {
            navigateToPreviousFragment()
        }

        with(guessFragmentBinding) {

            observeLiveData()

            val guessButtons = arrayOf(
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
            for (button in guessButtons) {
                button.setOnClickListener {
                    showNumberInputAndGuessResult(button.text.toString())
                }
            }

            clearButton.setOnClickListener {
                restartGame()
                showNumberInputAndGuessResult(getString(R.string.result_fail))
            }

            guessButton.setOnClickListener {
                gameResult(guessResultText.text.toString().toInt())
            }

        }
    }

    private fun observeLiveData(){
        guessViewModel.randomChar.observe(viewLifecycleOwner) { randomCharFromVM ->
            guessFragmentBinding.guessCharacterText.text = randomCharFromVM.toString()
        }
    }

    private fun gameResult(guessNumber: Int) {
        guessNumber.let {
            val result = guessViewModel.checkGuess(guessNumber)
            if (result) {
                showNumberInputAndGuessResult(getString(R.string.result_success))
                restartGame()
            } else {
                showNumberInputAndGuessResult(getString(R.string.result_fail))
            }
        }
    }

    private fun restartGame() {
        guessViewModel.generateRandomNumber()
    }

    private fun showNumberInputAndGuessResult(numberInput: String?) = with(guessFragmentBinding) {
        guessResultText.text = numberInput
    }

}