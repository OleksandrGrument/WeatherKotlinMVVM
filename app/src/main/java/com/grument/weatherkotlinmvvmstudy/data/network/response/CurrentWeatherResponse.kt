package com.grument.weatherkotlinmvvmstudy.data.network.response

import com.google.gson.annotations.SerializedName
import com.grument.weatherkotlinmvvmstudy.data.db.entity.CurrentWeatherEntry
import com.grument.weatherkotlinmvvmstudy.data.db.entity.WeatherLocation

data class CurrentWeatherResponse(

    @SerializedName("location")
    val location: WeatherLocation,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry

)