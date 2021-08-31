package com.book.exomind_test.ui.progress

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.book.exomind_test.data.remote.WeatherRepository
import com.book.exomind_test.data.remote.models.WeatherObject
import com.book.exomind_test.utils.ApiCallTask.launchPeriodicAsync
import kotlinx.coroutines.*
import java.util.*
import kotlin.concurrent.timerTask

class ProgressViewModel(val weatherRepository: WeatherRepository) : ViewModel() {


    private lateinit var task: Deferred<Unit>
    val WE_DOWNLOAD = "We download the data ..."

    val ALMOST_DONE = " It's almost done…"

    val FEW_SECONDS_LEFT = "Only a few seconds before getting the result ..."

    val listText = mutableListOf(WE_DOWNLOAD, ALMOST_DONE, FEW_SECONDS_LEFT)
    val listCities = mutableListOf("Rennes", "Paris", "Nantes", "Bordeaux", "Lyon")

    var userText = MutableLiveData<String>()
    var progressValue = MutableLiveData<Int>()
    var weatherOfCity = MutableLiveData<WeatherObject>()

    var cityCount = 0
    var displayTimer = 0
    val displayTimerTask = timerTask {
        userText.postValue(listText[displayTimer])
        if (displayTimer == 2) displayTimer = 0 else displayTimer++
    }

    init {
        Timer().scheduleAtFixedRate(displayTimerTask, 2000, 6000)
        executeCall()
    }


    var initialProgress = 0

    private fun executeCall() {
        task = viewModelScope.launchPeriodicAsync(10000) {
            if (cityCount == 4){
                task.cancel()
                userText.postValue("Completed")
                displayTimerTask.cancel()
            }
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val response = weatherRepository.callWeatherApi(listCities[cityCount])

                    if (response.isSuccessful && response.body() != null) {
                        val content = response.body()
                        weatherOfCity.postValue(content)
                        Log.d("result", content.toString())
                        initialProgress = initialProgress + 20
                        progressValue.postValue(initialProgress)
                        cityCount++
                    } else {
                        Log.d("Error", response.message())
                    }

                } catch (e: Exception) {
                    e.message?.let { Log.d("Error", it) }
                }
            }
        }
    }


}