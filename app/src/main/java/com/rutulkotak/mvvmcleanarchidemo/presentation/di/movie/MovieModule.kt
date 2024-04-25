package com.rutulkotak.mvvmcleanarchidemo.presentation.di.movie

import com.rutulkotak.mvvmcleanarchidemo.domain.usecase.GetMoviesUseCase
import com.rutulkotak.mvvmcleanarchidemo.domain.usecase.UpdateMoviesUseCase
import com.rutulkotak.mvvmcleanarchidemo.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}