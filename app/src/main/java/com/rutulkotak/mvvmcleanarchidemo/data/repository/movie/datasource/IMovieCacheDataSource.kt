package com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource

import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie

interface IMovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}