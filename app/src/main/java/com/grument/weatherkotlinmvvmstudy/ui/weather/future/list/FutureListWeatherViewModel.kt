package com.grument.weatherkotlinmvvmstudy.ui.weather.future.list

import androidx.lifecycle.ViewModel;
import com.grument.weatherkotlinmvvmstudy.data.provider.UnitProvider
import com.grument.weatherkotlinmvvmstudy.data.repository.ForecastRepository
import com.grument.weatherkotlinmvvmstudy.internal.lazyDeferred
import com.grument.weatherkotlinmvvmstudy.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel (

    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider

): WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeferred {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }

}
