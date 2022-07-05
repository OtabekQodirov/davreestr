package com.example.myapplication.app.fragment.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAboutBinding
import com.example.myapplication.databinding.FragmentMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class AboutFragment : Fragment() {
    private val callback = OnMapReadyCallback { googleMap ->

        val uzb = LatLng(41.0, 64.0)
        googleMap.addMarker(MarkerOptions().position(uzb).title("Marker in Uzb"))
        //
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(uzb))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAboutBinding.inflate(inflater, container, false)

        //NOTE: WRITE HERE
        val mapFragment = childFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        return binding.root
    }
}