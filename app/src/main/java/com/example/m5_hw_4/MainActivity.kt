package com.example.m5_hw_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.m5_hw_4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initialize()
        initListener()
        listeners()
        setContentView(binding.root)

    }
    private fun listeners() {
        binding.btnPlus.setOnClickListener {
                viewModel.plus(it)
        }

        binding.btnMinus.setOnClickListener {
                viewModel.minus(it)
        }
        }

   private fun initListener(){
       viewModel.count.observe(this) { count ->
           binding.tv.text = count.toString()
       }
   }
    private fun initialize() {
       viewModel= ViewModelProvider(this)[MainViewModel::class.java]
    }
}