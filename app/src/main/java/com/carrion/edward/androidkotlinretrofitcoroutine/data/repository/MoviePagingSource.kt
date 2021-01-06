package com.carrion.edward.androidkotlinretrofitcoroutine.data.repository

import androidx.paging.PagingSource
import com.carrion.edward.androidkotlinretrofitcoroutine.data.api.ApiService
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.Movie
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource(private val apiService: ApiService) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: DEFAULT_PAGE_INDEX

        val response = apiService.movies(page)
        val results = response.results

        return try {
            LoadResult.Page(
                data = results,
                prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (results.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        const val DEFAULT_PAGE_INDEX = 1
    }
}