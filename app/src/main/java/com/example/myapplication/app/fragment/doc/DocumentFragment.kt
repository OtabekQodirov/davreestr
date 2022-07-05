package com.example.myapplication.app.fragment.doc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.app.adapter.DocAdapter
import com.example.myapplication.app.adapter.ECommerceAdapter
import com.example.myapplication.app.fragment.ecomerce.EcommerceViewModel
import com.example.myapplication.databinding.FragmentDocBinding
import com.example.myapplication.databinding.FragmentMainBinding

class DocumentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDocBinding.inflate(inflater, container, false)

        //NOTE: WRITE HERE
        val viewModel = ViewModelProvider(this)[DocViewModel::class.java]
        val adapter = DocAdapter()
        binding.recycler.adapter = adapter

        viewModel.getDoc().observe(viewLifecycleOwner) {
            adapter.list = it
        }


        return binding.root
    }
}