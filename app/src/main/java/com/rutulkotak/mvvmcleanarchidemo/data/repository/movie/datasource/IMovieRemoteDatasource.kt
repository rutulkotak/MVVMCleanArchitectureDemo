package com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource

import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.MovieList
import retrofit2.Response

interface IMovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}