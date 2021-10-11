package com.example.earthquake

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _eqList = MutableLiveData<MutableList<Earthquake>>()
    val eqList: LiveData<MutableList<Earthquake>>
        get() = eqList

    init {
        fetchEarthquakes()
    }

    private fun fetchEarthquakes() {
        val eqList = mutableListOf<Earthquake>()

        eqList.add(Earthquake("1","57 km E of NY",4.3,273845126,-102.4756,28.47365))
        eqList.add(Earthquake("2","80 km E of NJ",4.6,273845126,-102.4756,28.47365))
        eqList.add(Earthquake("3","78 km E of YN",4.4,273845126,-102.4756,28.47365))

        _eqList.value = eqList

    }
}