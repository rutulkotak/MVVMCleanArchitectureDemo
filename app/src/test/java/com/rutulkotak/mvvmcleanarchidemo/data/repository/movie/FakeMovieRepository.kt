package com.rutulkotak.mvvmcleanarchidemo.data.repository.movie

import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie
import com.rutulkotak.mvvmcleanarchidemo.domain.repository.IMovieRepository

class FakeMovieRepository: IMovieRepository {

    private val movies = mutableListOf<Movie>()

    init {
        movies.addAll(getDummyMovies())
    }

    override suspend fun getMovies(): List<Movie> {
        return movies
    }

    override suspend fun updateMovies(): List<Movie> {
        movies.clear()
        movies.addAll(updateDummyMovies())
        return movies
    }

    private fun getDummyMovies(): List<Movie> {
        return listOf(
            Movie(1, "Overview-1", "posterPath-1", "ReleaseDate-1", "Title-1"),
            Movie(2, "Overview-2", "posterPath-2", "ReleaseDate-2", "Title-2"),
            Movie(3, "Overview-3", "posterPath-3", "ReleaseDate-3", "Title-3")
        )
    }

    private fun updateDummyMovies(): List<Movie> {
        return listOf(
            Movie(1, "Overview-1", "posterPath-1", "ReleaseDate-1", "Title-1"),
            Movie(2, "Overview-2", "posterPath-2", "ReleaseDate-2", "Title-2"),
            Movie(3, "Overview-3", "posterPath-3", "ReleaseDate-3", "Title-3"),
            Movie(4, "Overview-4", "posterPath-4", "ReleaseDate-4", "Title-4"),
            Movie(5, "Overview-5", "posterPath-5", "ReleaseDate-5", "Title-5")
        )
    }
}