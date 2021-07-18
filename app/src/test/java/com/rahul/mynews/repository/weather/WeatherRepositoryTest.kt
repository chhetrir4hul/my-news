package com.rahul.mynews.repository.weather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.rahul.mynews.FileReader
import com.rahul.mynews.JSON_FILE_WEATHER_RESPONSE
import com.rahul.mynews.MainCoroutineRule
import com.rahul.mynews.data.Resource
import com.rahul.mynews.network.WeatherApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

@ExperimentalCoroutinesApi
class WeatherRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var mockWebServer: MockWebServer

    private lateinit var weatherApi: WeatherApi

    private lateinit var weatherRepository: WeatherRepository

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start(8000)

        weatherApi = Retrofit.Builder().baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WeatherApi::class.java)

        weatherRepository = WeatherRepository(weatherApi)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `should return success resource on successful api call`() = runBlocking {
        val response = MockResponse().setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(FileReader.readTestResourcesFile(JSON_FILE_WEATHER_RESPONSE))

        mockWebServer.enqueue(response)

        val repositoryResponse = weatherRepository.getWeatherByCity("sydney")

        assertThat(repositoryResponse).isInstanceOf(Resource.Success::class.java)
    }

    @Test
    fun `should return error resource on unsuccessful api call`() = runBlocking {
        val response = MockResponse().setResponseCode(HttpURLConnection.HTTP_FORBIDDEN)
            .setBody("")

        mockWebServer.enqueue(response)

        val repositoryResponse = weatherRepository.getWeatherByCity("sydney")

        assertThat(repositoryResponse).isInstanceOf(Resource.Error::class.java)
    }
}