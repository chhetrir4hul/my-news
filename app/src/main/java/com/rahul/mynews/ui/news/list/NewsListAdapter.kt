package com.rahul.mynews.ui.news.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rahul.mynews.data.Article
import com.rahul.mynews.databinding.ItemNewsBinding

class NewsListAdapter(private val articleList: List<Article>) :
    RecyclerView.Adapter<NewsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemNewsBinding.inflate(layoutInflater, parent, false)
        return NewsListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(articleList[position])
        holder.itemView.setOnClickListener {
            val action =
                NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(articleList[position])
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = articleList.size
}