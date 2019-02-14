package com.grument.weatherkotlinmvvmstudy.data.network.response

import com.google.gson.annotations.SerializedName
import com.grument.weatherkotlinmvvmstudy.data.db.entity.WeatherLocation



data class FutureWeatherResponse(
    @SerializedName("forecast")
    val futureWeatherEntries: ForecastDaysContainer,
    val location: WeatherLocation
)