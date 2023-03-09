package com.example.weather.data.api

import com.example.weather.BuildConfig
import com.example.weather.data.api.response.MenuItemsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodMenuItemsService {
    @GET("/food/menuItems/search")
    suspend fun getFoodMenuItems(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("query") query: String?,
        @Query("minCalories") minCalories: Int?,
        @Query("maxCalories") maxCalories: Int?,
        @Query("minCarbs") minCarbs: Int?,
        @Query("maxCarbs") maxCarbs: Int?,
        @Query("minProtein") minProtein: Int?,
        @Query("maxProtein") maxProtein: Int?,
        @Query("minFat") minFat: Int?,
        @Query("maxFat") maxFat: Int?,
        @Query("addMenuItemInformation") addMenuItemInformation: Boolean?,
        @Query("offset") offset: Int?,
        @Query("number") number: Int?
    ): MenuItemsResponse
}