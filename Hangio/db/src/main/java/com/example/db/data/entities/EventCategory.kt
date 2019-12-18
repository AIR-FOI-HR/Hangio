package com.example.db.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "event_category")
data class EventCategory (
    @ColumnInfo(name = "idevent_category")
    @PrimaryKey(autoGenerate = true)
    var idEventCategory : Int,
    @ColumnInfo(name = "category_title")
    var categoryTitle : String
)