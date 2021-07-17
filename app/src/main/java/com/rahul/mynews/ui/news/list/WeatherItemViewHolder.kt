package com.rahul.mynews.ui.news.list

import androidx.recyclerview.widget.RecyclerView
import com.rahul.mynews.R
import com.rahul.mynews.data.WeatherResponse
import com.rahul.mynews.databinding.ItemWeatherBinding
import com.rahul.mynews.util.GlideImageLoader

class WeatherItemViewHolder(private val itemWeatherBinding: ItemWeatherBinding) :
    RecyclerView.ViewHolder(itemWeatherBinding.root) {
    fun bind(weather: WeatherResponse?) = with(itemWeatherBinding) {

        weather?.let {
            GlideImageLoader(ivWeatherIcon).loadWeatherIcon(it.weather[0].icon)
            tvTemperature.text =
                itemView.context.getString(R.string.txt_temperature, it.main.temp)
            tvLocation.text = it.name
        }
    }
}