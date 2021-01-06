package com.carrion.edward.androidkotlinretrofitcoroutine.data.model

import com.google.gson.annotations.SerializedName

data class MovieResult(
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("results")
    val results: List<Movie>
)