@file:Suppress("TrailingComma")

package com.example.m5_hw_4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel() {

    private val _count:MutableLiveData<Int> = MutableLiveData()
    val count:LiveData<Int> = _count
     var variable = 0

    fun plus(){
        if (variable==10){
        }else{
            variable ++
            _count.value = variable
        }
   }

    fun minus(){
        if (variable==0){
        }else{
            variable --
            _count.value = variable
        }
    }

}