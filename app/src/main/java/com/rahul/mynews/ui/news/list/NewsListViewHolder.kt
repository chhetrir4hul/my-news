package com.rahul.mynews.ui.news.list

import androidx.recyclerview.widget.RecyclerView
import com.rahul.mynews.data.Article
import com.rahul.mynews.databinding.ItemNewsBinding
import com.rahul.mynews.util.DateTimeUtil
import com.rahul.mynews.util.GlideImageLoader

class NewsListViewHolder(private val itemNewsBinding: ItemNewsBinding) :
    RecyclerView.ViewHolder(itemNewsBinding.root) {
    fun bind(article: Article) = with(itemNewsBinding) {
        tvTitle.text = article.title
        tvPublishedAt.text = DateTimeUtil.getFormattedDate(article.publishedAt)
        GlideImageLoader(ivImage).load(article.urlToImage)
    }
}