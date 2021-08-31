package com.book.exomind_test.data.remote

import com.book.exomind_test.data.remote.models.WeatherObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiInterface {

    @GET("weather")
    suspend fun getWeatherOfCity(
        @Query("q") city: String, @Query("appid") appid: String
    ): Response<WeatherObject>
}
