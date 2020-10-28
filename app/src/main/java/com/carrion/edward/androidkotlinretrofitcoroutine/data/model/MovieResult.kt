package com.carrion.edward.androidkotlinretrofitcoroutine.data.model

import com.google.gson.annotations.SerializedName

data class MovieResult(
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("results")
    val results: List<Movie>
)

data class Movie(
    val id: Int,
    val title: String,
    val popularity: Float,
    val name: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val vote: Float,
    @SerializedName("poster_path")
    val posterPath: String
)