package com.example.m5_hw_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.m5_hw_4.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


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
            if (viewModel.variable == 10){
                Snackbar.make(binding.root, "Вы достигли цели!", Snackbar.LENGTH_SHORT).show()
            }else{
                viewModel.plus()
            }
        }

        binding.btnMinus.setOnClickListener {
            if (viewModel.variable == 0){
                Snackbar.make(binding.root, "Вы достигли цели!", Snackbar.LENGTH_SHORT).show()
            }else{
                viewModel.minus()
            }
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