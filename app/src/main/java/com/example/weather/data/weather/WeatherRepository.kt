package com.example.weather.data.weather

import com.example.weather.BuildConfig
import com.example.weather.data.api.WeatherService
import com.example.weather.data.api.response.WeatherResponse
import retrofit2.http.Query

interface WeatherRepository {
    suspend fun getWeatherInfo(
        serviceKey: String = BuildConfig.SERVICE_KEY,
        pageNo: String,
        numOfRows: String,
        dataType: String = "JSON",
        baseDate: String,
        baseTime: String = "0500",
        nx: String,
        ny: String,
    ): WeatherResponse
}

class DefaultWeatherRepository(private val service: WeatherService): WeatherRepository {
    override suspend fun getWeatherInfo(
        serviceKey: String,
        pageNo: String,
        numOfRows: String,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String
    ): WeatherResponse {
        return kotlin.run {
            service.getWeatherInfo(
                BuildConfig.SERVICE_KEY,
                pageNo,
                numOfRows,
                dataType,
                baseDate,
                baseTime,
                nx,
                ny
            )
        }
    }
}