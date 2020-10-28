package com.carrion.edward.androidkotlinretrofitcoroutine.di

import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.MovieDataSource
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.MovieRepository

object Injection {
    private val museumRepository = MovieRepository()
    fun providerRepository(): MovieDataSource = museumRepository
}