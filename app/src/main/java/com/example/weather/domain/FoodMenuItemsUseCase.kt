package com.example.weather.domain

import com.example.weather.data.api.request.MenuItemsRequest
import com.example.weather.data.api.response.MenuItemsResponse
import com.example.weather.data.food.FoodMenuItemsRepository
import com.example.weather.di.IODispatcher
import com.example.weather.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FoodMenuItemsUseCase @Inject constructor(
    private val foodMenuItemsRepository: FoodMenuItemsRepository,
    @IODispatcher ioDispatcher: CoroutineDispatcher,
): FlowUseCase<MenuItemsRequest, MenuItemsResponse>(ioDispatcher) {
    override fun execute(parameters: MenuItemsRequest): Flow<Result<MenuItemsResponse>> = flow {
        emit(Result.Loading)
        emit(
            Result.Success(foodMenuItemsRepository.getMenuItems(
                query = parameters.query,
                minCalories = parameters.minCalories,
                maxCalories = parameters.maxCalories,
                minCarbs = parameters.minCarbs,
                maxCarbs = parameters.maxCarbs,
                minProtein = parameters.minProtein,
                maxProtein = parameters.maxProtein,
                minFat = parameters.minFat,
                maxFat = parameters.maxFat,
                addMenuItemInformation = parameters.addMenuItemInformation,
                offset = parameters.offset,
                number = parameters.number
            ))
        )
    }
}