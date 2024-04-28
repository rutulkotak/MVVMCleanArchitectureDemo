package com.rutulkotak.mvvmcleanarchidemo.presentation.di.core

import com.rutulkotak.mvvmcleanarchidemo.domain.repository.IMovieRepository
import com.rutulkotak.mvvmcleanarchidemo.domain.usecase.GetMoviesUseCase
import com.rutulkotak.mvvmcleanarchidemo.domain.usecase.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: IMovieRepository) : GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: IMovieRepository) : UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }
}