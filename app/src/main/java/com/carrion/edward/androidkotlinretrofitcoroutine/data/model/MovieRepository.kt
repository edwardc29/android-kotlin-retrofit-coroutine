package com.carrion.edward.androidkotlinretrofitcoroutine.data.model

import com.carrion.edward.androidkotlinretrofitcoroutine.data.api.ApiClient
import com.carrion.edward.androidkotlinretrofitcoroutine.data.api.Result

class MovieRepository : MovieDataSource {
    override suspend fun retrieveMovies(page: Int): Result<MovieResult> {
        try {
            val response = ApiClient.build()?.movies(page)
            response?.let {
                return if (it.isSuccessful && it.body() != null) {
                    val data = it.body()
                    Result.Success(data)
                } else {
                    val message = it.message()
                    Result.Error(Exception(message))
                }
            } ?: run { return Result.Error(Exception("Error occurred!")) }
        } catch (exception: Exception) {
            return Result.Error(exception)
        }
    }
}