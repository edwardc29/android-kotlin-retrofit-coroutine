package com.carrion.edward.androidkotlinretrofitcoroutine.view.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.Movie
import com.carrion.edward.androidkotlinretrofitcoroutine.data.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieViewModel @ViewModelInject constructor(private val movieRepository: MovieRepository) : ViewModel() {
    fun loadMovies(): Flow<PagingData<Movie>> {
        return movieRepository.retrieveMovies().cachedIn(viewModelScope)
    }
}