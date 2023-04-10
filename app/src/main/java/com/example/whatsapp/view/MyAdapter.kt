package com.example.whatsapp.view

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.whatsapp.FragmentOne
import com.example.whatsapp.FragmentStatus

class MyAdapter(var context: Context, fm: FragmentManager?) : FragmentPagerAdapter(
    fm!!
) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return FragmentOne()
            }
            1 -> {
                return FragmentStatus()
            }
            2 -> {
                return callFragment()
            }
        }
        return null!!
    }

    override fun getCount(): Int {
        return 3
    }
}