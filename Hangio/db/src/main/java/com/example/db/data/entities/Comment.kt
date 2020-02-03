package com.example.db.data.entities

import android.app.usage.UsageEvents
import androidx.room.*
import com.example.db.data.converters.DateConverter
import java.util.*

@Entity(tableName = "comment",foreignKeys = arrayOf(
    ForeignKey(entity = Event::class,
        parentColumns = arrayOf("idevent"),
        childColumns = arrayOf("event_id"),
        onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = User::class,
        parentColumns = arrayOf("iduser"),
        childColumns = arrayOf("user_id"),
        onDelete = ForeignKey.CASCADE)))
@TypeConverters(DateConverter::class)
data class Comment (
    @ColumnInfo(name="idcomment",index=true)
    @PrimaryKey(autoGenerate = true)
    var idComment : Int,
    @ColumnInfo(name= "event_id",index = true)
    var eventId : Int,
    @ColumnInfo(name= "user_id",index = true)
    var userId : Int,
    @ColumnInfo(name= "text")
    var text : String,
    @ColumnInfo(name = "post_time")
    var postTime : Date
)