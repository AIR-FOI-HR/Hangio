package com.example.db.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city")
data class City (
    @ColumnInfo(name = "idcity")
    @PrimaryKey(autoGenerate = true)
    var idCity : Int,
    @ColumnInfo(name = "city_name")
    var cityName : String
)