package com.example.db.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "user_event",foreignKeys = arrayOf(
    ForeignKey(entity = User::class,
        parentColumns = arrayOf("iduser"),
        childColumns = arrayOf("user_id"),
        onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = Event::class,
        parentColumns = arrayOf("idevent"),
        childColumns = arrayOf("event_id"),
        onDelete = ForeignKey.CASCADE)
))
data class UserEvent (
    @ColumnInfo(name = "iduser_event")
    @PrimaryKey(autoGenerate = true)
    var idUserEvent : Int,
    @ColumnInfo(name = "user_id",index = true)
    var userId : Int,
    @ColumnInfo(name = "event_id", index=true)
    var eventId : Int
)