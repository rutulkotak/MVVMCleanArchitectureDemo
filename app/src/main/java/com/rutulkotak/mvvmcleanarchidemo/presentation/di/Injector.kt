package com.rutulkotak.mvvmcleanarchidemo.presentation.di

import com.rutulkotak.mvvmcleanarchidemo.presentation.di.movie.MovieSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}