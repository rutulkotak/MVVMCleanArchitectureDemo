package com.rutulkotak.mvvmcleanarchidemo.domain.repository

import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie

interface IMovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}