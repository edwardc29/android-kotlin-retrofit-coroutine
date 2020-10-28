package com.carrion.edward.androidkotlinretrofitcoroutine.data.model

import com.carrion.edward.androidkotlinretrofitcoroutine.data.api.Result

interface MovieDataSource {
    suspend fun retrieveMovies(page: Int): Result<MovieResult>
}