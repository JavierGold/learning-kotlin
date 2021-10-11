package com.example.earthquake.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.earthquake.Earthquake
import com.example.earthquake.database.getDatabase
import kotlinx.coroutines.*
import java.net.UnknownHostException

private val TAG = MainViewModel::class.java.simpleName
class MainViewModel(application: Application): AndroidViewModel(application) {




    private val database = getDatabase(application)
    private val repository = MainRepository(database)

    val eqList = repository.eqList

    init {
        viewModelScope.launch {
            try {
                repository.fetchEarthquakes()
            }catch (e: UnknownHostException){
                Log.d(TAG,"no internet connection",e)
            }

        }
    }
}