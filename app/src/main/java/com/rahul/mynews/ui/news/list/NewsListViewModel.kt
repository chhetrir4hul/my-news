package com.rahul.mynews.ui.news.list

import android.util.Log
import com.rahul.mynews.data.ApiResult
import com.rahul.mynews.data.Resource
import com.rahul.mynews.data.TopHeadlineResponse
import com.rahul.mynews.network.NewsApi
import com.rahul.mynews.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(private val newsApi: NewsApi) : BaseViewModel() {
    fun fetchHeadlines() {
        executeApiRequest({ newsApi.getTopHeadlines("au") },
            object : ApiResult<TopHeadlineResponse> {
                override fun onResponse(apiResult: Resource<TopHeadlineResponse>) {
                }
            }
        )
    }
}