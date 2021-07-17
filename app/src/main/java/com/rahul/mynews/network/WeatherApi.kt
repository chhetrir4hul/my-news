package com.rahul.mynews.network

import com.rahul.mynews.data.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather?units=metric")
    suspend fun getWeatherByCity(@Query("q") city: String): Response<WeatherResponse>
}