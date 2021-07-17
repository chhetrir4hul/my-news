package com.rahul.mynews.ui.news.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rahul.mynews.data.Article
import com.rahul.mynews.data.WeatherResponse
import com.rahul.mynews.databinding.ItemNewsBinding
import com.rahul.mynews.databinding.ItemWeatherBinding

class NewsListAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_WEATHER = 1
        const val TYPE_NEWS = 2
    }

    private var articleList: List<Article> = emptyList()

    private var weatherResponse: WeatherResponse? = null

    fun setWeatherResponse(weatherResponse: WeatherResponse?) {
        this.weatherResponse = weatherResponse
        notifyItemChanged(0)
    }

    fun setArticleList(articleList: List<Article>) {
        this.articleList = articleList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_WEATHER) {
            val itemBinding = ItemWeatherBinding.inflate(layoutInflater, parent, false)
            WeatherItemViewHolder(itemBinding)
        } else {
            val itemBinding = ItemNewsBinding.inflate(layoutInflater, parent, false)
            NewsListViewHolder(itemBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is WeatherItemViewHolder) {
            holder.bind(weatherResponse)
        } else if (holder is NewsListViewHolder) {
            val article = articleList[position - 1]
            holder.bind(article)
            holder.itemView.setOnClickListener {
                val action =
                    NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(
                        article
                    )
                it.findNavController().navigate(action)
            }
        }

    }

    override fun getItemCount() = articleList.size + 1

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_WEATHER
            else -> TYPE_NEWS
        }
    }
}