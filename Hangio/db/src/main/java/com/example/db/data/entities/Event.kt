package com.example.db.data.entities

import androidx.room.*
import com.example.db.data.converters.DateConverter
import java.io.Serializable
import java.util.*

@Entity(tableName = "event"/*,foreignKeys = arrayOf(
    ForeignKey(entity = User::class,
        parentColumns = arrayOf("iduser"),
        childColumns = arrayOf("creator_id"),
        onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(entity = City::class,
        parentColumns = arrayOf("idcity"),
        childColumns = arrayOf("city_id"),
        onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = EventCategory::class,
        parentColumns = arrayOf("idevent_category"),
        childColumns = arrayOf("event_category_id"),
        onDelete = ForeignKey.CASCADE))*/)
@TypeConverters(DateConverter::class)
data class Event (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idevent")
    var idEvent: Int,
    @ColumnInfo(name = "title")
    var title : String,
    @ColumnInfo(name = "start_date")
    var startDate : Date,
    @ColumnInfo(name = "address")
    var address : String,
    @ColumnInfo(name = "description")
    var description : String,
    @ColumnInfo(name = "capacity")
    var capacity : Int?,
    @ColumnInfo(name = "registered")
    var registered : Int?,
    @ColumnInfo(name="creator_id",index = true)
    var creatorId : Int,
    @ColumnInfo(name="city_id", index = true)
    var cityId : Int,
    @ColumnInfo(name="event_category_id", index = true)
    var eventCategoryId : Int
) : Serializable