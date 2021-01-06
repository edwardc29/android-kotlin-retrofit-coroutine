package com.carrion.edward.androidkotlinretrofitcoroutine.data.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: List<Movie>)

    @Query("SELECT * FROM movie_table")
    fun getAllMovies(): PagingSource<Int, Movie>

    @Query("DELETE FROM movie_table where id = :id")
    suspend fun clearMovies(id: Int)
}