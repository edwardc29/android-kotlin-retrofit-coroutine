package com.carrion.edward.androidkotlinretrofitcoroutine.data.api

import com.carrion.edward.androidkotlinretrofitcoroutine.BuildConfig
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.MovieResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(BuildConfig.MOVIES)
    suspend fun movies(@Query("page") page: Int): MovieResult
}