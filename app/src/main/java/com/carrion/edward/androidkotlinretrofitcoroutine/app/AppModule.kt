package com.carrion.edward.androidkotlinretrofitcoroutine.app

import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.MovieDataSource
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
interface AppModule {

    @Binds
    fun bindMovieDataSource(movieRepository: MovieRepository): MovieDataSource
}