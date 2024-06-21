package com.example.newsappsunil.presentation.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsappsunil.presentation.ui.fragment.CategoryFragment

class CategoryPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val categories =
        listOf("business", "entertainment", "general", "health", "science", "sports", "technology")

    override fun getItemCount(): Int = categories.size

    override fun createFragment(position: Int): Fragment {
        val fragment = CategoryFragment()
        fragment.arguments = Bundle().apply {
            putString("category", categories[position])
        }
        return fragment
    }
}