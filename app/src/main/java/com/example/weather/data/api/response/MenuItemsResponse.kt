package com.example.weather.data.api.response

import androidx.annotation.Keep

@Keep
data class MenuItemsResponse (
    val menuItems: List<MenuItems> = listOf(MenuItems()),
    val totalMenuItems: Int = 0,
    val type: String = "",
    val offset: Int = 0,
    val number: Int = 0
)

@Keep
data class MenuItems (
    val id: Int = 0,
    val title: String = "",
    val restaurantChain: String = "",
    val image: String = "",
    val imageType: String = "",
    val servings: Servings = Servings()
)

@Keep
data class Servings (
    val number: Int = 0,
    val size: Int = 0,
    val unit: String = ""
)
