package com.example.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.api.request.WeatherRequest
import com.example.weather.domain.WeatherUseCase
import com.example.weather.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val WeatherUseCase: WeatherUseCase
): ViewModel() {
    init {
        getWeatherInfo()
    }

    private fun getWeatherInfo () = viewModelScope.launch {
        WeatherUseCase(WeatherRequest(
            serviceKey = "g6O5ef0kcowEWRWvCcfw0cvHsAWJwE%2FYmemqm9cRpCjkkzgnrZUfUfaV%2BzuvHaB2Cj5M3wKFkhINqV9C29hT2Q%3D%3D",
            pageNo = "1",
            numOfRows = "1000",
            dataType = "JSON",
            baseDate = "20230305",
            baseTime = "0500",
            nx = "55",
            ny = "127"
        )).collectLatest {
            Timber.d("test check it data $it")
            if (it is Result.Success) {
                Timber.d("test check it data inner $it")
            }
        }
    }
}