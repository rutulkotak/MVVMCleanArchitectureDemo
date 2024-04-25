package com.rutulkotak.mvvmcleanarchidemo.data.api

import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.MovieList
import retrofit2.Response

interface RemoteDataService {

    suspend fun getPopularMovies(): Response<MovieList>
}