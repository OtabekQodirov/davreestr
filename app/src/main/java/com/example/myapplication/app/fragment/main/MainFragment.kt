package com.example.myapplication.app.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.myapplication.R
import com.example.myapplication.app.adapter.ViewPagerAdapter
import com.example.myapplication.data.remote.ResponseBean
import com.example.myapplication.databinding.FragmentEcommerceBinding
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.domain.ApiCallback

class MainFragment : Fragment(), ApiCallback {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //NOTE: WRITE HERE
        val adapter = ViewPagerAdapter(this)
        binding.viewPager2.adapter = adapter


        binding.cadSearch.setOnClickListener {
            viewModel.getCadInfo("31231", this)
        }

        return binding.root
    }

    override fun onSuccess(response: ResponseBean) {
        // TODO:
        Toast.makeText(context, response.address, Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(message: String) {
        // TODO:
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}