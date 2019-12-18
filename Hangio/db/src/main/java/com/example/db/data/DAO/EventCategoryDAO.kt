package com.example.db.data.DAO

import androidx.room.*
import com.example.db.data.entities.EventCategory


@Dao
interface EventCategoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEventCategory(eventCategory: EventCategory)

    @Delete
    fun deleteEventCategory(eventCategory: EventCategory)

    @Query("SELECT * FROM event_category")
    fun getAllEventCategories(): List<EventCategory>
}