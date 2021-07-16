package com.rahul.mynews.ui.news.list

import androidx.recyclerview.widget.RecyclerView
import com.rahul.mynews.data.Article
import com.rahul.mynews.databinding.ItemNewsBinding

class NewsListViewHolder(private val itemNewsBinding: ItemNewsBinding) :
    RecyclerView.ViewHolder(itemNewsBinding.root) {
    fun bind(article: Article) = with(itemNewsBinding) {
        tvTitle.text = article.title
        tvPublishedAt.text = article.publishedAt
    }
}