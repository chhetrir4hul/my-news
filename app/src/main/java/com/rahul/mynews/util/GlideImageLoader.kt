package com.rahul.mynews.util

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader(private val imageView: ImageView) {
    fun load(imageUrl: String?) {
        Glide.with(imageView.context).load(imageUrl).into(imageView)
    }

    fun loadWeatherIcon(iconCode: String) {
        load("https://openweathermap.org/img/wn/$iconCode@2x.png")
    }
}