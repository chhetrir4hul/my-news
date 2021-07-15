package com.rahul.mynews.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {
    @Provides
    fun providesNewsApiService(retrofit: Retrofit) = retrofit.create(NewsApi::class.java)
}