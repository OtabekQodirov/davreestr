package com.example.myapplication.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ecommerce")
data class ECommerceEntity(
    @PrimaryKey val id: Int,
    val name_uz: String?,
    val name_ru: String?,
    val name_en: String?,
    val description_uz: String?,
    val description_ru: String?,
    val description_en: String?,
    @ColumnInfo(name = "url_address") val url: String?
)
