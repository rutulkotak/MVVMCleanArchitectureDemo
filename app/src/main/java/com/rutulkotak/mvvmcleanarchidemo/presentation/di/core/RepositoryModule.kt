package com.rutulkotak.mvvmcleanarchidemo.presentation.di.core

import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.MovieRepositoryImpl
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieCacheDataSource
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieLocalDataSource
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieRemoteDatasource
import com.rutulkotak.mvvmcleanarchidemo.domain.repository.IMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: IMovieRemoteDatasource,
        movieLocalDataSource: IMovieLocalDataSource,
        movieCacheDataSource: IMovieCacheDataSource
    ) : IMovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }
}