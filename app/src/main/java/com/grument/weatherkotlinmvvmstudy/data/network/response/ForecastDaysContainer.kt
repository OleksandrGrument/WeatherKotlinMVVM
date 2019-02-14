package com.grument.weatherkotlinmvvmstudy.data.network.response

import com.google.gson.annotations.SerializedName
import com.grument.weatherkotlinmvvmstudy.data.db.entity.FutureWeatherEntry


data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)