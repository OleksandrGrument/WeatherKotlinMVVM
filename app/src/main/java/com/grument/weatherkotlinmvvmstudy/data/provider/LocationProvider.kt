package com.grument.weatherkotlinmvvmstudy.data.provider

import com.grument.weatherkotlinmvvmstudy.data.db.entity.WeatherLocation

interface LocationProvider {

    suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocation) : Boolean
    suspend fun getPreferredLocationString(): String
}