package com.example.weather.data.api.response

import androidx.annotation.Keep

@Keep
data class WeatherResponse (
    val response: Response = Response()
)

@Keep
data class Response (
    val header: Header = Header(),
    val body: Body = Body()
)

@Keep
data class Header (
    val resultCode: String = "",
    val resultMsg: String = "",
)

@Keep
data class Body(
    val dataType: String = "",
    val items: Items = Items(),
    val numOfRows: Int = 0,
    val pageNo: Int = 0,
    val totalCount: Int = 0
)

@Keep
data class Items (
    val item: List<Item> = listOf(Item())
)

@Keep
data class Item (
    val baseDate: String = "",
    val baseTime: String = "",
    val category: String = "",
    val fcstDate: String = "",
    val fcstTime: String = "",
    val fcstValue: String= "",
    val nx: Int = 0,
    val ny: Int = 0
)