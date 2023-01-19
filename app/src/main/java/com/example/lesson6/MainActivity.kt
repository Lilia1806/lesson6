package com.example.lesson6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson6.databinding.ActivityMainBinding
import com.example.lesson6.fragment.FirstFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, FirstFragment())
            .commit()
    }
}