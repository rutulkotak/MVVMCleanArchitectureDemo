package com.rutulkotak.mvvmcleanarchidemo.data.repository.movie

import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieCacheDataSource
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieLocalDataSource
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.datasource.IMovieRemoteDatasource
import com.rutulkotak.mvvmcleanarchidemo.domain.repository.IMovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDatasource: IMovieRemoteDatasource,
    private val movieLocalDataSource: IMovieLocalDataSource,
    private val movieCacheDataSource: IMovieCacheDataSource
): IMovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val movieList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(movieList)
        movieCacheDataSource.saveMoviesToCache(movieList)
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        var movieList: List<Movie>
        movieList = movieCacheDataSource.getMoviesFromCache()
        if (movieList.isEmpty()) {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        var movieList: List<Movie>
        movieList = movieLocalDataSource.getMoviesFromDB()
        if (movieList.isEmpty()) {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        /*
        var movieList = emptyList<Movie>()
        val responseBody = movieRemoteDatasource.getMovies().body()
        if (responseBody != null) {
            movieList = responseBody.movies
        }
        */

        return getModieList().toList()
    }

    private fun getModieList(): Collection<Movie> {
        val movieList = mutableListOf<Movie>()
        movieList.add(Movie(1, "overview-1", "PosterPath-1", "ReleaseDate-1", "Title-1"))
        movieList.add(Movie(2, "overview-2", "PosterPath-2", "ReleaseDate-2", "Title-2"))
        movieList.add(Movie(3, "overview-3", "PosterPath-3", "ReleaseDate-3", "Title-3"))
        movieList.add(Movie(4, "overview-4", "PosterPath-4", "ReleaseDate-4", "Title-4"))
        movieList.add(Movie(5, "overview-5", "PosterPath-5", "ReleaseDate-5", "Title-5"))
        movieList.add(Movie(6, "overview-6", "PosterPath-6", "ReleaseDate-6", "Title-6"))
        movieList.add(Movie(7, "overview-7", "PosterPath-7", "ReleaseDate-7", "Title-7"))
        movieList.add(Movie(8, "overview-8", "PosterPath-8", "ReleaseDate-8", "Title-8"))
        movieList.add(Movie(9, "overview-9", "PosterPath-9", "ReleaseDate-9", "Title-9"))
        movieList.add(Movie(10, "overview-10", "PosterPath-11", "ReleaseDate-10", "Title-10"))
        return movieList
    }
}