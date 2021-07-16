package com.rahul.mynews.network

import com.rahul.mynews.data.TopHeadlineResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines?sortBy=publishedAt")
    suspend fun getTopHeadlines(@Query("country") country: String): Response<TopHeadlineResponse>
}