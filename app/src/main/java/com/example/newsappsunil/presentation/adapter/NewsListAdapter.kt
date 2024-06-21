package com.example.newsappsunil.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappsunil.R
import com.example.newsappsunil.data.model.NewsResponse
import com.example.newsappsunil.databinding.ListItemNewsBinding

class NewsListAdapter :
    RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {

    private var mData = emptyList<NewsResponse.ArticlesItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(friendData: List<NewsResponse.ArticlesItem>) {
        mData = friendData
        notifyDataSetChanged()
    }

    inner class NewsListViewHolder(
        private val binding: ListItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NewsResponse.ArticlesItem) {

            binding.tvTitle.text = item.title ?: "Dummy title here"
            binding.tvDescription.text = item.description ?: "Dummy description here"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        return NewsListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_news,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(mData[position])
    }
}