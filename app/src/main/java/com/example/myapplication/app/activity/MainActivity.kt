package com.example.myapplication.app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.app.fragment.ecomerce.ECommerceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ECommerceFragment())
                .commit()
        }
    }
}