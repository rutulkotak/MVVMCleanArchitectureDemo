package com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasourceimpl

import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieCacheDataSource

class MovieCacheDataSourceImpl: IMovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movieList)
    }
}