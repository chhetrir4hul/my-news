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
            GlideImageLoader(ivWeatherIcon).loadWeatherIcon(weather.weather[0].icon)
            tvTemperature.text =
                itemView.context.getString(R.string.txt_temperature, weather.main.temp)
            tvLocation.text = weather.name
        } ?: run { tvLocation.text = itemView.context.getString(R.string.txt_loading) }
    }
}