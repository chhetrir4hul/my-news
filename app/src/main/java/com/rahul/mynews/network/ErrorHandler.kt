package com.rahul.mynews.network

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rahul.mynews.data.ErrorResponse
import com.rahul.mynews.data.Resource
import okhttp3.ResponseBody

object ErrorHandler {

    fun <T> parseError(responseBody: ResponseBody?): Resource.Error<T> {
        val gson = Gson()
        val type = object : TypeToken<ErrorResponse>() {}.type
        val errorResponse: ErrorResponse? =
            gson.fromJson(responseBody?.charStream(), type)
        return Resource.Error(errorResponse?.message ?: "An unknown error occurred")
    }
}