package com.example.weather.data.api

import com.example.weather.BuildConfig
import com.example.weather.data.api.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("/1360000/VilageFcstInfoService_2.0/getVilageFcst")
    suspend fun getWeatherInfo(
        @Query("serviceKey") serviceKey: String = BuildConfig.SERVICE_KEY,
        @Query("pageNo") pageNo: String,
        @Query("numOfRows") numOfRows: String,
        @Query("dataType") dataType: String = "JSON",
        @Query("base_date") baseDate: String,
        @Query("base_time") baseTime: String = "0500",
        @Query("nx") nx: String,
        @Query("ny") ny: String,
    ): WeatherResponse
}
