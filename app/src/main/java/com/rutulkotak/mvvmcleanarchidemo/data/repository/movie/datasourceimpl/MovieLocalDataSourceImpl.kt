package com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasourceimpl

import com.rutulkotak.mvvmcleanarchidemo.data.db.MovieDao
import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieLocalDataSource

class MovieLocalDataSourceImpl(
    private val movieDao: MovieDao
) : IMovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        movieDao.saveMovies(movies)
    }

    override suspend fun clearAll() {
        movieDao.deleteAllMovies()
    }
}