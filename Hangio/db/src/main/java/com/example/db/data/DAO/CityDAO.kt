package com.example.db.data.DAO

import androidx.room.*
import com.example.db.data.entities.City

@Dao
interface CityDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(city: City)

    @Delete
    fun deleteCity(city: City)

    @Query("SELECT * FROM city")
    fun getAllCities(): List<City>

}