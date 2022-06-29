package com.example.myapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ECommerceDAO {

    @Query("SELECT * FROM ecommerce")
    fun getAll(): LiveData<List<ECommerceEntity>>

    @Query("SELECT * FROM ecommerce WHERE id = :id")
    fun findById(id: Int): LiveData<ECommerceEntity>

    @Query("SELECT * FROM ecommerce WHERE id = :id AND url_address = :url_address ")
    fun findByUrl(id: Int, url_address: String): LiveData<ECommerceEntity>

}


