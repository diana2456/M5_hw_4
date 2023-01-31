@file:Suppress("TrailingComma")

package com.example.m5_hw_4

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar


class MainViewModel: ViewModel() {

    private val _count:MutableLiveData<Int> = MutableLiveData()
    val count:LiveData<Int> = _count
    private var variable = 0

    fun plus(view: View){
        if (variable==10){
           snackBar(view)
        }else{
            variable ++
            _count.value = variable
        }
   }

    fun minus(view: View){
        if (variable==0){
          snackBar(view)
        } else{
            variable --
            _count.value = variable
        }
    }
    fun snackBar(view:View){
       Snackbar.make(view,"Вы достигли цели! \uD83E\uDD70",Snackbar.LENGTH_LONG).show()
    }
}