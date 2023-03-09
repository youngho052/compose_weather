package com.example.weather.view

import com.example.weather.data.api.response.MenuItemsResponse

data class MainScreenUiState(
    val menuItems: MenuItemsResponse = MenuItemsResponse()
)