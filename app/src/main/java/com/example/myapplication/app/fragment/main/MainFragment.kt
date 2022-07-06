package com.example.myapplication.app.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.app.adapter.ViewPagerAdapter
import com.example.myapplication.databinding.FragmentEcommerceBinding
import com.example.myapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        //NOTE: WRITE HERE
        val adapter = ViewPagerAdapter(this)
        binding.viewPager2.adapter = adapter

        return binding.root
    }
}