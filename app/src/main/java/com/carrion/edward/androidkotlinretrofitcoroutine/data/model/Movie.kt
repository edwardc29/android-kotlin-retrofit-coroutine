package com.carrion.edward.androidkotlinretrofitcoroutine.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey
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
) : Parcelable