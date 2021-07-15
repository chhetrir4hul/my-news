package com.rahul.mynews.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rahul.mynews.data.ApiResult
import com.rahul.mynews.data.ErrorResponse
import com.rahul.mynews.data.Resource
import kotlinx.coroutines.launch
import retrofit2.HttpException

abstract class BaseViewModel : ViewModel() {

    fun <T> executeApiRequest(request: suspend () -> T, apiResult: ApiResult<T>) {
        viewModelScope.launch {
            try {
                val response = request()
                apiResult.onResponse(Resource.success(response))
            } catch (throwable: Throwable) {
                if (throwable is HttpException) {
                    throwable.response()?.errorBody()?.let {
                        val gson = Gson()
                        val type = object : TypeToken<ErrorResponse>() {}.type
                        val errorResponse: ErrorResponse? = gson.fromJson(it.charStream(), type)
                        apiResult.onResponse(
                            Resource.error(
                                null,
                                errorResponse?.message ?: "An unknown error occurred."
                            )
                        )
                    }
                } else {
                    apiResult.onResponse(Resource.error(null, "An unknown error occurred."))
                }
            }
        }
    }
}