package com.rahul.mynews.repository.news

import com.rahul.mynews.data.Resource
import com.rahul.mynews.data.TopHeadlineResponse
import com.rahul.mynews.network.ErrorHandler
import com.rahul.mynews.network.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi) : INewsRepository {
    override suspend fun getTopHeadlines(countryCode: String): Resource<TopHeadlineResponse> {
        return try {
            val response = newsApi.getTopHeadlines(countryCode)
            val result = response.body()

            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                ErrorHandler.parseError(response.errorBody())
            }
        } catch (exception: Exception) {
            Resource.Error(exception.message ?: "An error occurred")
        }
    }
}