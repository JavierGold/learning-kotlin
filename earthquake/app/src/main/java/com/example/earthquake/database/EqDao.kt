package com.example.earthquake.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.earthquake.Earthquake


@Dao
interface EqDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(eqList: MutableList<Earthquake>)

    @Query("select * from earthquakes")
    fun getEarthquakes(): MutableList<Earthquake>

    @Query("select * from earthquakes ORDER BY magnitude DESC")
    fun getEarthquakesByMagnitude(): MutableList<Earthquake>
}