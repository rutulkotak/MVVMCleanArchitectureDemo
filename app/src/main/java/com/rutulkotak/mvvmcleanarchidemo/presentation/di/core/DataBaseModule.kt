package com.rutulkotak.mvvmcleanarchidemo.presentation.di.core

import android.app.Application
import androidx.room.Room
import com.rutulkotak.mvvmcleanarchidemo.data.db.DemoAppDatabase
import com.rutulkotak.mvvmcleanarchidemo.data.db.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(app: Application) : DemoAppDatabase {
        return Room.databaseBuilder(
            app,
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