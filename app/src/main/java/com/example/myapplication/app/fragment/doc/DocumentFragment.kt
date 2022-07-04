package com.example.myapplication.app.fragment.doc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
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

        return binding.root
    }
}