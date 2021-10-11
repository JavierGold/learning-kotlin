package com.example.earthquake

import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


interface EqApiService {
    @GET("all_hour.geojson")
    suspend fun getLastHourEarthquakes(): String
}

private var retrofit = Retrofit.Builder()
    .baseUrl("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/")
    .addConverterFactory(ScalarsConverterFactory.create())
    .build()

var service: EqApiService = retrofit.create(EqApiService::class.java)

