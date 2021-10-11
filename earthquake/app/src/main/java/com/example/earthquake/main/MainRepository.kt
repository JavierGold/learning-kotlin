package com.example.earthquake.main

import androidx.room.RoomDatabase
import com.example.earthquake.Earthquake
import com.example.earthquake.api.EqJsonResponse
import com.example.earthquake.api.service
import com.example.earthquake.database.EqDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val database: EqDatabase) {
     suspend fun fetchEarthquakes(): MutableList<Earthquake> {
        return withContext(Dispatchers.IO){
            val eqJsonResponse = service.getLastHourEarthquakes()
            val eqList =  parseEqResult(eqJsonResponse)
            eqList

        }
    }

    private fun parseEqResult(eqJsonResponse: EqJsonResponse): MutableList<Earthquake>{
        val eqList = mutableListOf<Earthquake>()
        val featureList = eqJsonResponse.features

        for(feature in featureList){
            val properties = feature.properties

            val id = feature.id
            val magnitude = properties.mag
            val place = properties.place
            val time = properties.time

            val geometry = feature.geometry
            val longitude = geometry.longitude
            val latitude = geometry.latitude

            eqList.add(Earthquake(id,place,magnitude,time,longitude,latitude))
        }

        return eqList
    }
}