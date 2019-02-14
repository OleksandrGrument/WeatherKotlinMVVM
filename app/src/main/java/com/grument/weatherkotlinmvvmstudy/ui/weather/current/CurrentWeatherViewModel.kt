package com.grument.weatherkotlinmvvmstudy.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.grument.weatherkotlinmvvmstudy.data.provider.UnitProvider
import com.grument.weatherkotlinmvvmstudy.data.repository.ForecastRepository
import com.grument.weatherkotlinmvvmstudy.internal.UnitSystem
import com.grument.weatherkotlinmvvmstudy.internal.lazyDeferred
import com.grument.weatherkotlinmvvmstudy.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred() {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }

}
