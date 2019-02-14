package com.grument.weatherkotlinmvvmstudy.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.grument.weatherkotlinmvvmstudy.data.network.response.CurrentWeatherResponse
import com.grument.weatherkotlinmvvmstudy.data.network.response.FutureWeatherResponse
import com.grument.weatherkotlinmvvmstudy.internal.NoConnectivityException

const val FORECAST_DAYS_COUNT = 7

class WeatherNetworkDataSourceImpl(

    private val apixuWeatherApiService: ApixuWeatherApiService

) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()

    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() {
            return _downloadedCurrentWeather
        }

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {

            val fetchedCurrentWeather = apixuWeatherApiService
                .getCurrentWeather(location, languageCode)
                .await()

            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)

        } catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection", e)
        }
    }

    private val _downloadedFutureWeather = MutableLiveData<FutureWeatherResponse>()

    override val downloadedFutureWeather: LiveData<FutureWeatherResponse>
        get() {
            return _downloadedFutureWeather
        }

    override suspend fun fetchFutureWeather(location: String, languageCode: String) {
        try {

            val fetchedCurrentWeather = apixuWeatherApiService
                .getFutureWeather(location,7, languageCode)
                .await()

            _downloadedFutureWeather.postValue(fetchedCurrentWeather)

        } catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection", e)
        }
    }
}