package com.carrion.edward.androidkotlinretrofitcoroutine.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carrion.edward.androidkotlinretrofitcoroutine.data.api.Result
import com.carrion.edward.androidkotlinretrofitcoroutine.data.api.Result.Error
import com.carrion.edward.androidkotlinretrofitcoroutine.data.api.Result.Success
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.MovieDataSource
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.MovieResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val mainRepository: MovieDataSource) : ViewModel() {
    private val _users = MutableLiveData<MovieResult>()
    val users: LiveData<MovieResult> = _users

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    private val _isEmptyList = MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList


    fun loadUsers(page: Int) {
        _isViewLoading.postValue(true)
        viewModelScope.launch {
            val result: Result<MovieResult> = withContext(Dispatchers.IO) {
                mainRepository.retrieveMovies(page)
            }
            _isViewLoading.postValue(false)

            when (result) {
                is Success -> {
                    if (result.data == null) {
                        _isEmptyList.postValue(true)
                    } else {
                        _users.value = result.data
                    }
                }

                is Error -> {
                    _onMessageError.postValue(result.exception)
                }
            }
        }
    }
}