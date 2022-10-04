package com.example.coint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.coint.databinding.ActivityMainBinding
import com.example.coint.ui.ConverterFragment
import com.example.coint.ui.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(HomeFragment())

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.convert -> {
                    loadFragment(ConverterFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}