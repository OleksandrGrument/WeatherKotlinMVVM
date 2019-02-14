package com.grument.weatherkotlinmvvmstudy.data.provider

import com.grument.weatherkotlinmvvmstudy.internal.UnitSystem

interface UnitProvider{

    fun getUnitsSystem(): UnitSystem
}