package com.example.earthquake.main

import android.app.Application
import androidx.lifecycle.*
import com.example.earthquake.Earthquake
import com.example.earthquake.database.getDatabase
import kotlinx.coroutines.*

class MainViewModel(application: Application): AndroidViewModel(application) {
    private var _eqList = MutableLiveData<MutableList<Earthquake>>()
    val eqList: LiveData<MutableList<Earthquake>>
        get() = _eqList

    private val database = getDatabase(application)
    private val repository = MainRepository(database)

    init {
        viewModelScope.launch {
            _eqList.value = repository.fetchEarthquakes()
        }
    }
}