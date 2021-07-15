package com.rahul.mynews.repository.news

import com.rahul.mynews.data.Resource
import com.rahul.mynews.data.TopHeadlineResponse

interface INewsRepository {
    suspend fun getTopHeadlines(countryCode: String): Resource<TopHeadlineResponse>
}