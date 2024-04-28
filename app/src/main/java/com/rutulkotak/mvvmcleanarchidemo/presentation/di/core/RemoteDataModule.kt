package com.rutulkotak.mvvmcleanarchidemo.presentation.di.core

import com.rutulkotak.mvvmcleanarchidemo.data.api.RemoteDataService
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieRemoteDatasource
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(
        remoteDataService: RemoteDataService
    ) : IMovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(remoteDataService)
    }
}