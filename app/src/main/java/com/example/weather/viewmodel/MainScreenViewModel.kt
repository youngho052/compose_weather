package com.example.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.api.request.MenuItemsRequest
import com.example.weather.data.api.request.WeatherRequest
import com.example.weather.domain.FoodMenuItemsUseCase
import com.example.weather.domain.WeatherUseCase
import com.example.weather.result.Result
import com.example.weather.view.MainScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase,
    private val foodMenuItemsUseCase: FoodMenuItemsUseCase
): ViewModel() {
    private val _mainScreenUiState: MutableStateFlow<MainScreenUiState> =
        MutableStateFlow(MainScreenUiState())
    val mainScreenUiState: StateFlow<MainScreenUiState>
        get() = _mainScreenUiState

    init {
//        getWeatherInfo()
        getFoodMenuItems()
    }

    private fun getFoodMenuItems () = viewModelScope.launch {
        foodMenuItemsUseCase(MenuItemsRequest(
            query = "burger",
            number = 2,
        )).collectLatest {
            Timber.d("check api sdsdsd $it")
            if(it is Result.Success) {
                _mainScreenUiState.value = _mainScreenUiState.value.copy(
                    menuItems = it.data
                )
            }
        }
    }

//    private fun getWeatherInfo () = viewModelScope.launch {
//        WeatherUseCase(WeatherRequest(
//            serviceKey = "g6O5ef0kcowEWRWvCcfw0cvHsAWJwE%2FYmemqm9cRpCjkkzgnrZUfUfaV%2BzuvHaB2Cj5M3wKFkhINqV9C29hT2Q%3D%3D",
//            pageNo = "1",
//            numOfRows = "100",
//            dataType = "JSON",
//            baseDate = "20230307",
//            baseTime = "0500",
//            nx = "55",
//            ny = "127"
//        )).collectLatest {
//            Timber.d("test check it data $it")
//            if (it is Result.Success) {
//                Timber.d("test check it data inner $it")
//            }
//        }
//    }
}