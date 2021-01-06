package com.carrion.edward.androidkotlinretrofitcoroutine.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.carrion.edward.androidkotlinretrofitcoroutine.data.api.ApiService
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.Movie
import com.carrion.edward.androidkotlinretrofitcoroutine.data.repository.MoviePagingSource.Companion.DEFAULT_PAGE_INDEX
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val apiService: ApiService) {

    fun retrieveMovies(
        pagingConfig: PagingConfig = PagingConfig(pageSize = DEFAULT_PAGE_INDEX, enablePlaceholders = false)
    ): Flow<PagingData<Movie>> {
        return Pager(config = pagingConfig, pagingSourceFactory = { MoviePagingSource(apiService) }).flow
    }
}