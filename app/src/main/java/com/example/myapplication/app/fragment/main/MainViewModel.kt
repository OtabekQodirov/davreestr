package com.example.myapplication.app.fragment.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.domain.ApiCallback
import com.example.myapplication.domain.Repository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Repository(application)

    fun getCadInfo(cadNum:String, apiCallback: ApiCallback){
        repository.searchInfo(cadNum,apiCallback)
    }
}