package com.rahul.mynews.network

import com.rahul.mynews.BASE_URL_WEATHER
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {
    @Provides
    fun providesNewsApiService(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)

    @Provides
    fun providesWeatherApiService(retrofit: Retrofit): WeatherApi {
        return retrofit.newBuilder().baseUrl(BASE_URL_WEATHER).build()
            .create(WeatherApi::class.java)
    }
}