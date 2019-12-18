package com.example.db.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "user",
    foreignKeys = arrayOf(
        ForeignKey(entity = City::class,
            parentColumns = arrayOf("idcity"),
            childColumns = arrayOf("city_id"),
            onDelete = CASCADE)
    ))
data class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "iduser")
    var idUser: Int,
    @ColumnInfo(name = "first_name")
    var firstName : String,
    @ColumnInfo(name = "last_name")
    var lastName : String,
    @ColumnInfo(name = "email")
    var email : String,
    @ColumnInfo(name = "password")
    var password : String,
//    @ColumnInfo(name = "dob")
//    var dob : Date?,
    @ColumnInfo(name = "photo")
    var photo : String?,
    @ColumnInfo(name = "notifications")
    var notifications : Boolean?,
    @ColumnInfo(name = "language")
    var language : String?,
    @ColumnInfo(name = "city_id",index = true)
    var cityId : Int

)