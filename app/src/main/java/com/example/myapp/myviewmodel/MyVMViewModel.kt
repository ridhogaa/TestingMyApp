package com.example.myapp.myviewmodel

import androidx.lifecycle.ViewModel

class MyVMViewModel : ViewModel() {
    var result = 0

    fun calculate(width: String, height: String, length: String) {
        result = width.toInt() * height.toInt() * length.toInt()
    }
}