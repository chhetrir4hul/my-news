package com.rahul.mynews.data

data class WeatherResponse(
    val main: MainTemperature,
    val name: String,
    val weather: List<Weather>
)