package com.example.secondtasksolution.view.episode2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondtasksolution.databinding.ActivityFragmentToFragmentBinding
import com.example.secondtasksolution.util.CallBackHandler
import com.example.secondtasksolution.util.FragmentController.navigateToFragmentWithExt

class FragmentToFragmentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFragmentToFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentToFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CallBackHandler.handleCallback(this@FragmentToFragmentActivity) {
            backToMainScreen()
        }

        navigateToListScreen()
    }

    private fun backToMainScreen(){
        finish()
    }

    private fun navigateToListScreen(){
        ListFragment().navigateToFragmentWithExt(this)
    }

}