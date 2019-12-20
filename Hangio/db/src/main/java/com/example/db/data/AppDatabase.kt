package com.example.db.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.db.data.DAO.*
import com.example.db.data.entities.*

@Database(entities = arrayOf(
    City::class, Comment::class, Event::class, EventCategory::class, User::class, UserEvent::class),
    version=1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CityDAO(): CityDAO
    abstract fun CommentDAO(): CommentDAO
    abstract fun EventDAO(): EventDAO
    abstract fun EventCategoryDAO(): EventCategoryDAO
    abstract fun UserDAO(): UserDAO
    abstract fun UserEventDAO():UserEventDAO

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java,"dbHangio.db")
            .build()
    }
}