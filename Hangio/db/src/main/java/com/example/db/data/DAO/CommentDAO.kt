package com.example.db.data.DAO

import androidx.room.*
import com.example.db.data.entities.Comment


@Dao
interface CommentDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(comment: Comment)

    @Delete
    fun deleteComment(comment: Comment)

    @Query("SELECT * FROM comment")
    fun getAllComments(): List<Comment>
}