package com.rutulkotak.mvvmcleanarchidemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
abstract class DemoAppDatabase : RoomDatabase() {
    abstract fun MovieDao(): MovieDao
}