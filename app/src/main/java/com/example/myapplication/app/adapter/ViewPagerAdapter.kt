package com.example.myapplication.app.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.R
import com.example.myapplication.app.fragment.main.ItemFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val title = arrayListOf(
        R.string.vp_1_title,
        R.string.vp_2_title,
        R.string.vp_3_title,
        R.string.vp_4_title,
        R.string.vp_5_title,
        R.string.vp_6_title,
        R.string.vp_7_title,
        R.string.vp_8_title,
        R.string.vp_9_title,
        R.string.vp_10_title
    )
    private val desc = arrayListOf(
        R.string.vp_1_detail,
        R.string.vp_2_detail,
        R.string.vp_3_detail,
        R.string.vp_4_detail,
        R.string.vp_5_detail,
        R.string.vp_6_detail,
        R.string.vp_7_detail,
        R.string.vp_8_detail,
        R.string.vp_9_detail,
        R.string.vp_10_detail

    )
    private val icon = arrayListOf(
        R.drawable.home_ic,
        R.drawable.prohibition_ic,
        R.drawable.value_ic,
        R.drawable.shaping_ic,
        R.drawable.ic_duplicate,
        R.drawable.ic_duplicate,
        R.drawable.ic_doc,
        R.drawable.ic_registration,
        R.drawable.ic_area,
        R.drawable.ic_registration,
    )

    override fun getItemCount() = title.size

    override fun createFragment(position: Int): Fragment {
        return ItemFragment.newInstance(title[position], desc[position], icon[position])
    }

}
