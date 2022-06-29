package com.example.myapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query


@Dao
interface DocumentDAO {

    @Query("SELECT * FROM document")
    fun getAll(): LiveData<List<DocumentEntity>>

    @Query("SELECT * FROM document WHERE id = :id")
    fun findById(id: Int): LiveData<DocumentEntity>

    @Query("SELECT * FROM document WHERE id = :id AND url_address = :url_address ")
    fun findByUrl(id: Int, url_address: String): LiveData<DocumentEntity>


}