package com.example.myapplication.app.fragment.doc

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.data.local.DocumentEntity
import com.example.myapplication.domain.Repository

class DocViewModel(application: Application) : AndroidViewModel(application) {
   private val repository = Repository(application)

    fun getDoc(): LiveData<List<DocumentEntity>> {
        return repository.getAllDocuments()

    }
}