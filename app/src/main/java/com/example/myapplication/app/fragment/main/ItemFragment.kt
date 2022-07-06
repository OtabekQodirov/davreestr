package com.example.myapplication.app.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ViewPagerItemBinding

class ItemFragment : Fragment() {

    companion object {
        private const val KEY_TITLE = "title"
        private const val KEY_DESC = "desc"
        private const val KEY_ICON = "icon"

        fun newInstance(titleId: Int, descId: Int, iconId: Int): ItemFragment {
            val args = Bundle()
            args.putInt(KEY_TITLE, titleId)
            args.putInt(KEY_DESC, descId)
            args.putInt(KEY_ICON, iconId)

            val fragment = ItemFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ViewPagerItemBinding.inflate(inflater, container, false)

        val titleId = arguments?.getInt(KEY_TITLE)
        val descId = arguments?.getInt(KEY_DESC)
        val iconId = arguments?.getInt(KEY_ICON)

        binding.title.text = context?.getString(titleId!!) ?: ""
        binding.details.text = context?.getString(descId!!) ?: ""
        binding.imageId.setImageResource(iconId!!)

        return binding.root
    }
}