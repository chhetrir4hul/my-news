package com.rahul.mynews.network

import com.rahul.mynews.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val url =
            request().url.newBuilder().addQueryParameter("apiKey", BuildConfig.NEWS_API_KEY).build()

        proceed(
            request().newBuilder().url(url).build()
        )
    }
}