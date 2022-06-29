package com.example.myapplication.domain

import com.example.myapplication.data.remote.ResponseBean

interface ApiCallback {

    fun onSuccess(response: ResponseBean)

    fun onFailure(message: String)
}