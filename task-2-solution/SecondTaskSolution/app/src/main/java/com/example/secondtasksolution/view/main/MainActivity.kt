package com.example.secondtasksolution.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondtasksolution.databinding.ActivityMainBinding
import com.example.secondtasksolution.util.Extension.getActivity
import com.example.secondtasksolution.view.episode1.ListActivity
import com.example.secondtasksolution.view.episode2.FragmentToFragmentActivity
import com.example.secondtasksolution.view.episode3.NavigationToNavigationActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            activityToActivityButton.setOnClickListener {
                getActivity(ListActivity())
            }

            fragmentToFragmentButton.setOnClickListener {
                getActivity(FragmentToFragmentActivity())
            }

            navFragmentToNavFragmentButton.setOnClickListener {
                getActivity(NavigationToNavigationActivity())
            }
        }
    }

}