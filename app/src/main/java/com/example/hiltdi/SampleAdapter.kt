package com.example.hiltdi

import javax.inject.Inject

class SampleAdapter @Inject constructor(){
    fun getItemsCount() = 8
}