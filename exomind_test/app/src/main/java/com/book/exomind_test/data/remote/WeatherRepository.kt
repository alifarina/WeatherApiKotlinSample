package com.book.exomind_test.data.remote

import com.book.exomind_test.data.remote.models.WeatherObject
import retrofit2.Response

class WeatherRepository {

    suspend fun callWeatherApi(city : String): Response<WeatherObject> {
        val apiInterface = ApiClient.getClient().create(WeatherApiInterface::class.java)
        val response = apiInterface.getWeatherOfCity(city,"18328bac6d6ad7ad1fa6e3c87678495c")
        return return response

    }
}