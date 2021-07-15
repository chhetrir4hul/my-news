package com.rahul.mynews.data

interface ApiResult<T> {
    fun onResponse(apiResult: Resource<T>)
}