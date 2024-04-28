package com.rutulkotak.mvvmcleanarchidemo.presentation.di.core

import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieCacheDataSource
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : IMovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
}