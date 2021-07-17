package com.rahul.mynews.repository.weather

import com.rahul.mynews.data.Resource
import com.rahul.mynews.data.WeatherResponse

interface IWeatherRepository {
    suspend fun getWeatherByCity(cityName: String): Resource<WeatherResponse>
}