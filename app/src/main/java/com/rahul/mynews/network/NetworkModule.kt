package com.rahul.mynews.network

import androidx.viewbinding.BuildConfig
import com.rahul.mynews.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideBaseUrl() = BASE_URL

    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun providesOkHttp(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
            .addInterceptor(RequestInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(provideBaseUrl())
            .addConverterFactory(providesGsonConverterFactory())
            .client(providesOkHttp())
            .build()
    }
}