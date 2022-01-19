package com.aria.footballapp.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.data.source.local.entity.TeamsEntity

@Database(entities = [TeamsEntity::class, EventsEntity::class], version = 1, exportSchema = false)
abstract class FootballDatabase : RoomDatabase() {
    abstract fun footballDao(): FootballDao

    companion object {
        @Volatile
        private var INSTANCE: FootballDatabase? = null

        fun getInstance(context: Context): FootballDatabase {
            synchronized(FootballDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FootballDatabase::class.java, "dbFootball"
                    )
                        .build()
                }
                return INSTANCE as FootballDatabase
            }
        }
    }
}