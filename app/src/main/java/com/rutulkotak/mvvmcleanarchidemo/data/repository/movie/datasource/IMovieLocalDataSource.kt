package com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource

import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie

interface IMovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}