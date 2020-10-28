package com.carrion.edward.androidkotlinretrofitcoroutine.view.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.MovieDataSource
import com.carrion.edward.androidkotlinretrofitcoroutine.view.viewmodel.MainViewModel

class ViewModelFactory(private val repository: MovieDataSource) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}