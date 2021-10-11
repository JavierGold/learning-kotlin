package com.example.earthquake.main

import android.app.Application
import androidx.lifecycle.*
import com.example.earthquake.Earthquake
import com.example.earthquake.database.getDatabase
import kotlinx.coroutines.*

class MainViewModel(application: Application): AndroidViewModel(application) {




    private val database = getDatabase(application)
    private val repository = MainRepository(database)

    val eqList = repository.eqList

    init {
        viewModelScope.launch {
            repository.fetchEarthquakes()
        }
    }
}