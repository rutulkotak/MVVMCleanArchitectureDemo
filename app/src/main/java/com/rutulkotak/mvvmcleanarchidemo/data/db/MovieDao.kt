package com.rutulkotak.mvvmcleanarchidemo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rutulkotak.mvvmcleanarchidemo.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movieList: List<Movie>)

    @Query("select * from popular_movies")
    suspend fun getMovies(): List<Movie>

    @Query("Delete from popular_movies")
    suspend fun deleteAllMovies()
}