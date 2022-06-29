package com.example.myapplication.data.local

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DocumentEntity::class, ECommerceEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun documentDao(): DocumentDAO
    abstract fun ecommerceDao(): ECommerceDAO

    companion object {
        private var db: AppDatabase? = null

        fun init(applicationContext: Context): AppDatabase {
            if (db == null) {
                synchronized(this) {
                    db = Room.databaseBuilder(
                        applicationContext,
                        AppDatabase::class.java, "davreestr"
                    ).build()
                }
            }

            return db!!
        }
    }
}