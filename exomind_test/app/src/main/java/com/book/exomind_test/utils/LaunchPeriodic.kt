package com.book.exomind_test.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

object ApiCallTask {

    fun CoroutineScope.launchPeriodicAsync(repeatMillis: Long, action: () -> Unit) = this.async {
        while (isActive) {
            action()
            delay(repeatMillis)
        }
    }
}