package com.example.firsttasksolution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firsttasksolution.databinding.ActivityMainBinding

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}