package com.example.myapplication.app.fragment.ecomerce

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.data.local.ECommerceEntity
import com.example.myapplication.domain.Repository

class EcommerceViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Repository(application)

    fun getEcommerce(): LiveData<List<ECommerceEntity>> {
        return repository.getAllECommerce()
    }
}