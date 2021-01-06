package com.carrion.edward.androidkotlinretrofitcoroutine.data.model

sealed class Result<out T> {
    data class Success<T>(val data: T?) : Result<T>()
    data class Error(val exception: Exception?) : Result<Nothing>()
}