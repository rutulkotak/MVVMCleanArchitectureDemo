package com.rutulkotak.mvvmcleanarchidemo.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.rutulkotak.mvvmcleanarchidemo.data.db.DemoAppDatabase
import com.rutulkotak.mvvmcleanarchidemo.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context) : DemoAppDatabase {
        return Room.databaseBuilder(
            context,
            DemoAppDatabase::class.java,
            "demodb"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(demoAppDatabase: DemoAppDatabase) : MovieDao {
        return demoAppDatabase.MovieDao()
    }
}