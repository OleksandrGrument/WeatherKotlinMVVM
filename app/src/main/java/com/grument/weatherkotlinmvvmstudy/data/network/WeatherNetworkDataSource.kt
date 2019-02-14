package com.grument.weatherkotlinmvvmstudy.data.network

import androidx.lifecycle.LiveData
import com.grument.weatherkotlinmvvmstudy.data.network.response.CurrentWeatherResponse
import com.grument.weatherkotlinmvvmstudy.data.network.response.FutureWeatherResponse


interface WeatherNetworkDataSource {

    val downloadedCurrentWeather : LiveData<CurrentWeatherResponse>
    val downloadedFutureWeather : LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode : String
    )

    suspend fun fetchFutureWeather(
        location: String,
        languageCode : String
    )
}