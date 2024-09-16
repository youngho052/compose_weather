package com.example.weather.domain

import com.example.weather.data.api.request.WeatherRequest
import com.example.weather.data.api.response.WeatherResponse
import com.example.weather.data.weather.WeatherRepository
import com.example.weather.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.example.weather.result.Result

class WeatherUseCase @Inject constructor(
    private val WeatherRepository: WeatherRepository,
    @IODispatcher ioDispatcher: CoroutineDispatcher
): FlowUseCase<WeatherRequest, WeatherResponse>(ioDispatcher) {
    override fun execute(WeatherRequest: WeatherRequest): Flow<Result<WeatherResponse>> = flow {
        emit(Result.Loading)
        emit(Result.Success(WeatherRepository.getWeatherInfo(
            serviceKey = WeatherRequest.serviceKey,
            pageNo = WeatherRequest.pageNo,
            numOfRows = WeatherRequest.numOfRows,
            dataType = WeatherRequest.dataType,
            baseDate = WeatherRequest.baseDate,
            baseTime = WeatherRequest.baseTime,
            nx = WeatherRequest.nx,
            ny = WeatherRequest.ny
        )))
    }
}