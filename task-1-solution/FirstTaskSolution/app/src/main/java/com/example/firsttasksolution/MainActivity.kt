<<<<<<< HEAD
package com.example.firsttasksolution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firsttasksolution.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
=======
package com.example.firsttasksolution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firsttasksolution.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
>>>>>>> 43ec3845c288fa7f2fcbcac537d0f051990d3c8f
}