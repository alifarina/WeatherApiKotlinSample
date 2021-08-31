package com.book.exomind_test.data.models

data class MainTempData(val temp: Double) {
    fun temperature() = "Temperature : $temp"
}