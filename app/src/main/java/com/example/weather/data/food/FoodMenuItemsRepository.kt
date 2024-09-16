package com.example.weather.data.food

import com.example.weather.BuildConfig
import com.example.weather.data.api.FoodMenuItemsService
import com.example.weather.data.api.response.MenuItemsResponse
import retrofit2.http.Query

interface FoodMenuItemsRepository {
    suspend fun getMenuItems (
        apiKey: String = BuildConfig.API_KEY,
        query: String?,
        minCalories: Int?,
        maxCalories: Int?,
        minCarbs: Int?,
        maxCarbs: Int?,
        minProtein: Int?,
        maxProtein: Int?,
        minFat: Int?,
        maxFat: Int?,
        addMenuItemInformation: Boolean?,
        offset: Int?,
        number: Int?
    ): MenuItemsResponse
}

class DefaultFoodMenuItemsRepository(
    private val service: FoodMenuItemsService
): FoodMenuItemsRepository {
    override suspend fun getMenuItems(
        apiKey: String,
        query: String?,
        minCalories: Int?,
        maxCalories: Int?,
        minCarbs: Int?,
        maxCarbs: Int?,
        minProtein: Int?,
        maxProtein: Int?,
        minFat: Int?,
        maxFat: Int?,
        addMenuItemInformation: Boolean?,
        offset: Int?,
        number: Int?
    ): MenuItemsResponse {
        return kotlin.run {
            service.getFoodMenuItems(
                BuildConfig.API_KEY,
                query,
                minCalories,
                maxCalories,
                minCarbs,
                maxCarbs,
                minProtein,
                maxProtein,
                minFat,
                maxFat,
                addMenuItemInformation,
                offset,
                number
            )
        }
    }
}