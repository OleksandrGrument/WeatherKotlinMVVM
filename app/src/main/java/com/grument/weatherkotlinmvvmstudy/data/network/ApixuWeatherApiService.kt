package com.grument.weatherkotlinmvvmstudy.data.network


import com.grument.weatherkotlinmvvmstudy.data.network.response.CurrentWeatherResponse
import com.grument.weatherkotlinmvvmstudy.data.network.response.FutureWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "e56cbc8cc5684abd96c104423180412"

//http://api.apixu.com/v1/current.json?key=e56cbc8cc5684abd96c104423180412&q=Kiev&Lang=en

interface ApixuWeatherApiService {

    companion object {
        operator fun invoke(

            connectivityInterceptor: ConnectivityInterceptor

        ): ApixuWeatherApiService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.apixu.com/v1/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)

        }
    }

    @GET("current.json")
    fun getCurrentWeather(
        @Query("q") location: String,
        @Query("lang") languageCode: String = "en"
    ): Deferred<CurrentWeatherResponse>

    @GET("forecast.json")
    fun getFutureWeather(@Query("q") location: String,
                         @Query("days") days: Int,
                         @Query("lang") languageCode: String = "en")
    : Deferred<FutureWeatherResponse>
}