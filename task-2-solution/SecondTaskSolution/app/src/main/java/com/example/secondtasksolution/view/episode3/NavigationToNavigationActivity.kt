package com.example.secondtasksolution.view.episode3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondtasksolution.databinding.ActivityNavigationToNavigationBinding

class NavigationToNavigationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNavigationToNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationToNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}