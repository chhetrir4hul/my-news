package com.rahul.mynews.ui.news.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.rahul.mynews.*
import com.rahul.mynews.data.Resource
import com.rahul.mynews.data.TopHeadlineResponse
import com.rahul.mynews.data.WeatherResponse
import com.rahul.mynews.repository.news.NewsRepository
import com.rahul.mynews.repository.weather.WeatherRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@ExperimentalCoroutinesApi
class NewsListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Rule
    @JvmField
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var newsRepository: NewsRepository

    @Mock
    lateinit var weatherRepository: WeatherRepository

    private lateinit var viewModel: NewsListViewModel

    @Before
    fun setup() {
        viewModel = NewsListViewModel(newsRepository, weatherRepository)
    }

    @Test
    fun `should set loading and success to livedata when repo returns success`() = runBlockingTest {
        val returnVal =
            Resource.Success(
                FileReader.parseTestResourceFile<TopHeadlineResponse>(
                    JSON_FILE_TOP_HEADLINES_RESPONSE
                )
            )

        `when`(newsRepository.getTopHeadlines("au")).thenReturn(returnVal)

        val values = viewModel.topHeadlineResponse.captureValues()

        viewModel.fetchHeadlines()

        assertThat(values[0]).isNull()

        assertThat(values[1]).isInstanceOf(Resource.Loading::class.java)

        assertThat(values[2]).isEqualTo(returnVal)
    }

    @Test
    fun `should set loading and error to livedata when repo returns error`() = runBlockingTest {
        val returnVal = Resource.Error<TopHeadlineResponse>("An error occurred", null)

        `when`(newsRepository.getTopHeadlines("au")).thenReturn(returnVal)

        val values = viewModel.topHeadlineResponse.captureValues()

        viewModel.fetchHeadlines()

        assertThat(values[0]).isNull()

        assertThat(values[1]).isInstanceOf(Resource.Loading::class.java)

        assertThat(values[2]).isEqualTo(returnVal)
    }

    @Test
    fun `should set success to livedata when weather repo returns success`() = runBlockingTest {
        val returnVal =
            Resource.Success(
                FileReader.parseTestResourceFile<WeatherResponse>(
                    JSON_FILE_WEATHER_RESPONSE
                )
            )

        `when`(weatherRepository.getWeatherByCity("sydney")).thenReturn(returnVal)

        viewModel.fetchWeather()

        val value = viewModel.weatherResponse.getOrAwaitValue()

        assertThat(value).isEqualTo(returnVal)
    }

    @Test
    fun `should set error to livedata when weather repo returns error`() = runBlockingTest {
        val returnVal = Resource.Error<WeatherResponse>("An error occurred", null)

        `when`(weatherRepository.getWeatherByCity("sydney")).thenReturn(returnVal)

        viewModel.fetchWeather()

        val value = viewModel.weatherResponse.getOrAwaitValue()

        assertThat(value).isEqualTo(returnVal)
    }
}