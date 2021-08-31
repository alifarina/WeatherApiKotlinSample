package com.book.exomind_test.data.remote.models

import com.book.exomind_test.data.models.Clouds
import com.book.exomind_test.data.models.MainTempData


data class WeatherObject(
    var coord: Coord,
    var weather: List<Weather>,
    var visibility: Int,
    var name: String,
    var main: MainTempData,
    var clouds: Clouds
) {

    fun cityName() ="City Name : $name"

}