package com.example.earthquake

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import org.json.JSONObject

class MainViewModel: ViewModel() {



    private var _eqList = MutableLiveData<MutableList<Earthquake>>()
    val eqList: LiveData<MutableList<Earthquake>>
        get() = _eqList

    init {
        viewModelScope.launch {
            _eqList.value = fetchEarthquakes()
        }

    }

    private suspend fun fetchEarthquakes(): MutableList<Earthquake> {
        return withContext(Dispatchers.IO){
            val eqListString = service.getLastHourEarthquakes()

            Log.d("manzana",eqListString)

            parseEqResult(eqListString)

            mutableListOf<Earthquake>()


        }
    }

    private fun parseEqResult(eqListString: String) {
        val eqJsonObject = JSONObject(eqListString)
    }


}