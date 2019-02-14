package com.grument.weatherkotlinmvvmstudy.ui.weather.future.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grument.weatherkotlinmvvmstudy.data.provider.UnitProvider
import com.grument.weatherkotlinmvvmstudy.data.repository.ForecastRepository
import com.grument.weatherkotlinmvvmstudy.data.repository.ForecastRepositoryImpl

class FutureListWeatherViewModelFactory(
    private val forecastRepository: ForecastRepository,
    private val unitProvider: UnitProvider
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T: ViewModel?> create(modelClass: Class<T>):T{

        return FutureListWeatherViewModel(
            forecastRepository,
            unitProvider
        ) as T
    }

}