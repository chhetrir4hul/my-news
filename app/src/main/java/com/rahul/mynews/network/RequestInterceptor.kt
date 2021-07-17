package com.rahul.mynews.network

import com.rahul.mynews.BASE_URL
import com.rahul.mynews.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        var url = request().url

        val urlBuilder = url.newBuilder()

        if (url.toString().startsWith(BASE_URL))
            urlBuilder.addQueryParameter("apiKey", BuildConfig.NEWS_API_KEY)
        else
            urlBuilder.addQueryParameter("appid", BuildConfig.WEATHER_API_KEY)

        url = urlBuilder.build()

        proceed(
            request().newBuilder().url(url).build()
        )
    }
}