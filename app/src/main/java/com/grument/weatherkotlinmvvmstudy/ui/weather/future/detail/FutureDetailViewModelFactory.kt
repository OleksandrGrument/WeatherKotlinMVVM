package com.grument.weatherkotlinmvvmstudy.ui.weather.future.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grument.weatherkotlinmvvmstudy.data.provider.UnitProvider
import com.grument.weatherkotlinmvvmstudy.data.repository.ForecastRepository
import org.threeten.bp.LocalDate


class FutureDetailViewModelFactory(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    private val unitProvider: UnitProvider
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FutureDetailWeatherViewModel(detailDate, forecastRepository, unitProvider) as T
    }


}