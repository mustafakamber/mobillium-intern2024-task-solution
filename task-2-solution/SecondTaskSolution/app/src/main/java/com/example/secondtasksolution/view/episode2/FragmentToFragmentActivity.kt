package com.example.secondtasksolution.view.episode2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.secondtasksolution.databinding.ActivityFragmentToFragmentBinding
import com.example.secondtasksolution.util.FragmentController.navigateToFragmentWithExt

class FragmentToFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentToFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentToFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToListScreen()
    }

    private fun navigateToListScreen() {
        ListFragment.newInstance().navigateToFragmentWithExt(this)
    }

}