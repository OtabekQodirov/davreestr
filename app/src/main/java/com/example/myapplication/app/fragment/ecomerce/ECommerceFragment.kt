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

class ECommerceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ecommerce, container, false)
        val viewModel = ViewModelProvider(this).get(EcommerceViewModel::class.java)
        val recycler: RecyclerView = view.findViewById(R.id.recycler)
        val adapter = ECommerceAdapter()
        recycler.adapter = adapter

        viewModel.getEcommerce().observe(viewLifecycleOwner) {
            adapter.list = it
        }

        return view
    }
}