package com.example.myapplication.app.fragment.ecomerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.app.adapter.ECommerceAdapter
import com.example.myapplication.databinding.FragmentEcommerceBinding

class ECommerceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentEcommerceBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this)[EcommerceViewModel::class.java]
        val recycler: RecyclerView = binding.recycler
        val adapter = ECommerceAdapter()
        recycler.adapter = adapter

        viewModel.getEcommerce().observe(viewLifecycleOwner) {
            adapter.list = it
        }

        return binding.root
    }
}