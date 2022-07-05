package com.example.myapplication.app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /* val view: View = LayoutInflater.from(this).inflate(R.layout.item_document, null)

         findViewById<ViewGroup>(R.id.frameLayout).addView(view)*/
    }
}