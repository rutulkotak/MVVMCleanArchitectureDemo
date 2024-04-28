package com.rutulkotak.mvvmcleanarchidemo.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.rutulkotak.mvvmcleanarchidemo.data.db.DemoAppDatabase
import com.rutulkotak.mvvmcleanarchidemo.data.db.MovieDao
import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieDao: MovieDao
    private lateinit var database: DemoAppDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            DemoAppDatabase::class.java
        ).build()
        movieDao = database.MovieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        movieDao.saveMovies(getMovies())

        // Test if movies is stored
        val dbMovies = movieDao.getMovies()
        Truth.assertThat(dbMovies).isEqualTo(getMovies())
    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        movieDao.saveMovies(getMovies())

        // Test if list is empty after delete
        movieDao.deleteAllMovies()
        val dbMovies = movieDao.getMovies()
        Truth.assertThat(dbMovies).isEmpty()
    }

    private fun getMovies(): List<Movie> {
        return listOf(
            Movie(1, "Overview-1", "posterPath-1", "ReleaseDate-1", "Title-1"),
            Movie(2, "Overview-2", "posterPath-2", "ReleaseDate-2", "Title-2"),
            Movie(3, "Overview-3", "posterPath-3", "ReleaseDate-3", "Title-3")
        )
    }
}