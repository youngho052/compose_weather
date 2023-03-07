package com.example.weather.data.api.request

import com.example.weather.BuildConfig

data class WeatherRequest (
    val serviceKey: String = BuildConfig.SERVICE_KEY,
    val pageNo: String = "",
    val numOfRows: String = "",
    val dataType: String = "JSON",
    val baseDate: String = "",
    val baseTime: String = "",
    val nx: String = "",
    val ny: String = ""
)