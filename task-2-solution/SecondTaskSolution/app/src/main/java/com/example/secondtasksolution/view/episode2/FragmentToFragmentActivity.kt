package com.example.secondtasksolution.view.episode2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.secondtasksolution.R
import com.example.secondtasksolution.databinding.ActivityFragmentToFragmentBinding

class FragmentToFragmentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFragmentToFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentToFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(ListFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.fragmentToFragment, fragment)
            commit()
        }
    }
}