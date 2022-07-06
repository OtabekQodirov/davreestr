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
        R.string.vp_4_title
    )
    private val desc = arrayListOf(
        R.string.vp_1_detail,
        R.string.vp_2_detail,
        R.string.vp_3_detail,
        R.string.vp_4_detail
    )
    private val icon = arrayListOf(
        R.drawable.add_ic,
        R.drawable.cad_search,
        R.drawable.ic_clock,
        R.drawable.ic_references
    )

    override fun getItemCount() = title.size

    override fun createFragment(position: Int): Fragment {
        return ItemFragment.newInstance(title[position], desc[position], icon[position])
    }

}
