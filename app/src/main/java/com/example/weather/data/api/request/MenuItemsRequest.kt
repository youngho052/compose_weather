package com.example.weather.data.api.request

data class MenuItemsRequest (
    val query: String? = null,
    val minCalories: Int? = null,
    val maxCalories: Int? = null,
    val minCarbs: Int? = null,
    val maxCarbs: Int? = null,
    val minProtein: Int? = null,
    val maxProtein: Int? = null,
    val minFat: Int? = null,
    val maxFat: Int? = null,
    val addMenuItemInformation: Boolean? = null,
    val offset: Int? = null,
    val number: Int? = null
)