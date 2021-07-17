package com.rahul.mynews.ui.news.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahul.mynews.data.Resource
import com.rahul.mynews.data.TopHeadlineResponse
import com.rahul.mynews.data.WeatherResponse
import com.rahul.mynews.repository.news.NewsRepository
import com.rahul.mynews.repository.weather.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
    private val weatherRepository: WeatherRepository
) :
    ViewModel() {

    var topHeadlineResponse = MutableLiveData<Resource<TopHeadlineResponse>>()
    var weatherResponse = MutableLiveData<Resource<WeatherResponse>>()

    init {
        fetchHeadlines()
    }

    private fun fetchHeadlines() {
        topHeadlineResponse.postValue(Resource.Loading(null))
        viewModelScope.launch {
            topHeadlineResponse.postValue(newsRepository.getTopHeadlines("au"))
            fetchWeather()
        }
    }

    private fun fetchWeather() {
        viewModelScope.launch {
            weatherResponse.postValue(weatherRepository.getWeatherByCity("sydney"))
        }
    }

}