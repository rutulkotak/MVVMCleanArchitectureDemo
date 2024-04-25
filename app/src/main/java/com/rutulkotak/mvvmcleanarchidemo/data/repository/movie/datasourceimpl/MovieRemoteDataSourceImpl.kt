package com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasourceimpl

import com.rutulkotak.mvvmcleanarchidemo.data.api.RemoteDataService
import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.MovieList
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val remoteDataService: RemoteDataService
) : IMovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> {
        return remoteDataService.getPopularMovies()
    }
}