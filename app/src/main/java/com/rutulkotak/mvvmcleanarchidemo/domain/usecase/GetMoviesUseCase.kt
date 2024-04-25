package com.rutulkotak.mvvmcleanarchidemo.domain.usecase

import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie
import com.rutulkotak.mvvmcleanarchidemo.domain.repository.IMovieRepository

class GetMoviesUseCase(private val movieRepository: IMovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}