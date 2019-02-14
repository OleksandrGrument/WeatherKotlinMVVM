package com.grument.weatherkotlinmvvmstudy.data.provider

import android.content.Context
import com.grument.weatherkotlinmvvmstudy.internal.UnitSystem

const val UNIT_SYSTEM = "UNIT_SYSTEM"

class UnitProviderImpl(context: Context) : PreferenceProvider(context), UnitProvider {


    override fun getUnitsSystem(): UnitSystem {

        val selectedName = preferences.getString(UNIT_SYSTEM, UnitSystem.METRIC.name)

        return UnitSystem.valueOf(selectedName!!)
    }
}