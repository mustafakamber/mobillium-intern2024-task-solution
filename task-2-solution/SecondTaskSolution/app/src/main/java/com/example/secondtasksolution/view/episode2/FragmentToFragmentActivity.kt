package com.example.secondtasksolution.view.episode2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.secondtasksolution.R
import com.example.secondtasksolution.databinding.ActivityFragmentToFragmentBinding
import com.example.secondtasksolution.util.Extension.getFragment

class FragmentToFragmentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFragmentToFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentToFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        }

        onBackPressedDispatcher.addCallback(callback)

        ListFragment().getFragment(this)
    }

}