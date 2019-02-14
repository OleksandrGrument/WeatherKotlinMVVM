package com.grument.weatherkotlinmvvmstudy

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import com.google.android.gms.location.LocationServices
import com.grument.weatherkotlinmvvmstudy.data.db.ForecastDatabase
import com.grument.weatherkotlinmvvmstudy.data.network.*
import com.grument.weatherkotlinmvvmstudy.data.provider.LocationProvider
import com.grument.weatherkotlinmvvmstudy.data.provider.LocationProviderImpl
import com.grument.weatherkotlinmvvmstudy.data.provider.UnitProvider
import com.grument.weatherkotlinmvvmstudy.data.provider.UnitProviderImpl
import com.grument.weatherkotlinmvvmstudy.data.repository.ForecastRepository
import com.grument.weatherkotlinmvvmstudy.data.repository.ForecastRepositoryImpl
import com.grument.weatherkotlinmvvmstudy.ui.weather.current.CurrentWeatherViewModelFactory
import com.grument.weatherkotlinmvvmstudy.ui.weather.future.detail.FutureDetailViewModelFactory
import com.grument.weatherkotlinmvvmstudy.ui.weather.future.list.FutureListWeatherViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*
import org.threeten.bp.LocalDate


class ForecastApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().futureWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
        bind<ForecastRepository>() with singleton {
            ForecastRepositoryImpl(
                instance(),
                instance(),
                instance(),
                instance(),
                instance()
            )
        }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance(), instance()) }
        bind() from provider { FutureListWeatherViewModelFactory(instance(), instance()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl(instance(), instance()) }
        bind() from factory{detailDate: LocalDate -> FutureDetailViewModelFactory(detailDate, instance(),instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}
