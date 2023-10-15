package com.example.globalnews.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.NavHostFragment

class ViewpagerAdapter(private val fragment: ArrayList<Fragment>, private val titles:ArrayList<String>, fm:FragmentManager):
FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getCount(): Int =fragment.size

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}