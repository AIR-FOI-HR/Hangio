package com.example.db.data.DAO

import androidx.room.*
import com.example.db.data.entities.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

}