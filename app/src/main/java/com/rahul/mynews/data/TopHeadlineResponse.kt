package com.rahul.mynews.data

data class TopHeadlineResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
