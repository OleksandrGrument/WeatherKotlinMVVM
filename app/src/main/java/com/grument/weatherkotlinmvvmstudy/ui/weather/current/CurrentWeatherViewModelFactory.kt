package com.grument.weatherkotlinmvvmstudy.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grument.weatherkotlinmvvmstudy.data.provider.UnitProvider
import com.grument.weatherkotlinmvvmstudy.data.repository.ForecastRepository

class CurrentWeatherViewModelFactory(

    private val forecastRepository: ForecastRepository,
    private val unitProvider: UnitProvider
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(forecastRepository, unitProvider) as T
    }

}