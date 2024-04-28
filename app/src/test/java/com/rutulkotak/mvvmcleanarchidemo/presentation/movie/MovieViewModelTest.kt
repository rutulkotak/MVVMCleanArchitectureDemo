package com.rutulkotak.mvvmcleanarchidemo.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie
import com.rutulkotak.mvvmcleanarchidemo.data.repository.movie.FakeMovieRepository
import com.rutulkotak.mvvmcleanarchidemo.domain.usecase.GetMoviesUseCase
import com.rutulkotak.mvvmcleanarchidemo.domain.usecase.UpdateMoviesUseCase
import com.rutulkotak.mvvmcleanarchidemo.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMovieUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMovieUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        movieViewModel = MovieViewModel(getMovieUseCase, updateMovieUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList() {
        val vmMovies = movieViewModel.getMovies().getOrAwaitValue()
        Truth.assertThat(getDummyMovies()).isEqualTo(vmMovies)
    }

    @Test
    fun updateMovies_returnsUpdatedList() {
        val vmMovies = movieViewModel.updateMovies().getOrAwaitValue()
        Truth.assertThat(updateDummyMovies()).isEqualTo(vmMovies)
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