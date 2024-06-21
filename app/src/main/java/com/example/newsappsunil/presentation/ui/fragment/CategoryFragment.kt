package com.example.newsappsunil.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappsunil.databinding.FragmentCategoryBinding
import com.example.newsappsunil.presentation.adapter.NewsListAdapter
import com.example.newsappsunil.presentation.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding

    private val viewModel: NewsViewModel by viewModels()
    private lateinit var adapter: NewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NewsListAdapter()
        binding.rvNews.adapter = adapter
        // Add the divider decoration
        val dividerItemDecoration = DividerItemDecoration(
            binding.rvNews.context,
            (binding.rvNews.layoutManager as LinearLayoutManager).orientation
        )
        binding.rvNews.addItemDecoration(dividerItemDecoration)

        val category = arguments?.getString("category") ?: "general"
        viewModel.getProductsDetails("in", category, "89404e91b7f14396951bbd6c8d823add")

        lifecycleScope.launch {
            viewModel.getNewsResponse.collect { data ->
                Log.d("TAG", "onViewCreated345345: ${data.body()}")
                data.body()?.articles?.let { adapter.setData(it) }
                binding.pbNews.isVisible = false
            }
        }
    }
}