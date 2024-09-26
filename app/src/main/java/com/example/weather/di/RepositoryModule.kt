package com.example.weather.di

import com.example.weather.data.api.FoodMenuItemsService
import com.example.weather.data.api.WeatherService
import com.example.weather.data.food.DefaultFoodMenuItemsRepository
import com.example.weather.data.food.FoodMenuItemsRepository
import com.example.weather.data.weather.DefaultWeatherRepository
import com.example.weather.data.weather.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun FoodMenuItemsRepository(
        service: FoodMenuItemsService
    ): FoodMenuItemsRepository {
        return DefaultFoodMenuItemsRepository(
            service
        )
    }

    @Provides
    @Singleton
    fun WeatherRepository(
        service: WeatherService
    ): WeatherRepository {
        return DefaultWeatherRepository(
            service
        )
    }
}