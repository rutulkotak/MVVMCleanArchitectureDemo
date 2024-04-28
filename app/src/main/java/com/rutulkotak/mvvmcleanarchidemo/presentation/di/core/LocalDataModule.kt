package com.rutulkotak.mvvmcleanarchidemo.presentation.di.core

import com.rutulkotak.mvvmcleanarchidemo.data.db.MovieDao
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieLocalDataSource
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : IMovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
}