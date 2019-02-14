package com.grument.weatherkotlinmvvmstudy.ui.base

import androidx.lifecycle.ViewModel
import com.grument.weatherkotlinmvvmstudy.data.provider.UnitProvider
import com.grument.weatherkotlinmvvmstudy.data.repository.ForecastRepository
import com.grument.weatherkotlinmvvmstudy.internal.UnitSystem
import com.grument.weatherkotlinmvvmstudy.internal.lazyDeferred


abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
): ViewModel()  {


    private val unitSystem = unitProvider.getUnitsSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}