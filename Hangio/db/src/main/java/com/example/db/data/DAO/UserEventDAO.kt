package com.example.db.data.DAO

import androidx.room.*
import com.example.db.data.entities.UserEvent


@Dao
interface UserEventDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserEvent(userEvent: UserEvent)

    @Delete
    fun deleteUserEvent(userEvent: UserEvent)

    @Query("SELECT * FROM user_event")
    fun getAllUserEvents(): List<UserEvent>
}