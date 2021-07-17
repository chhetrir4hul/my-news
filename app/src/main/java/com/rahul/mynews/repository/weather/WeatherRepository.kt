package com.rahul.mynews.repository.weather

import com.rahul.mynews.data.Resource
import com.rahul.mynews.data.WeatherResponse
import com.rahul.mynews.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherApi: WeatherApi) :
    IWeatherRepository {
    override suspend fun getWeatherByCity(cityName: String): Resource<WeatherResponse> {
        return try {
            val response = weatherApi.getWeatherByCity(cityName)
            val result = response.body()

            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (exception: Exception) {
            Resource.Error(exception.message ?: "An error occurred")
        }
    }
}