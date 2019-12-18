package com.example.db.data.DAO

import androidx.room.*
import com.example.db.data.entities.Event

@Dao
interface EventDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(event: Event)

    @Delete
    fun deleteEvent(event: Event)

    @Query("SELECT * FROM event")
    fun getAllEvents(): List<Event>

}