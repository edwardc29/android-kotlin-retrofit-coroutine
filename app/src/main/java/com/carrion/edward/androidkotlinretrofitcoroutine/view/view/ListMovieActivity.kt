package com.carrion.edward.androidkotlinretrofitcoroutine.view.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.carrion.edward.androidkotlinretrofitcoroutine.R
import com.carrion.edward.androidkotlinretrofitcoroutine.view.adapter.LoadingStateAdapter
import com.carrion.edward.androidkotlinretrofitcoroutine.view.adapter.MovieAdapter
import com.carrion.edward.androidkotlinretrofitcoroutine.view.base.BaseActivity
import com.carrion.edward.androidkotlinretrofitcoroutine.view.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_movie.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListMovieActivity : BaseActivity() {

    private val movieViewModel by viewModels<MovieViewModel>()
    private lateinit var movieAdapter: MovieAdapter

    override fun getLayout() = R.layout.activity_movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        movieAdapter = MovieAdapter()

        movieAdapter.addLoadStateListener { loadStates ->
            if (loadStates.refresh is LoadState.Loading) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE

                val error = when {
                    loadStates.prepend is LoadState.Error -> loadStates.prepend as LoadState.Error
                    loadStates.append is LoadState.Error -> loadStates.append as LoadState.Error
                    loadStates.refresh is LoadState.Error -> loadStates.refresh as LoadState.Error
                    else -> null
                }

                error?.let {
                    Toast.makeText(this, it.error.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        movieAdapter.withLoadStateFooter(
            footer = LoadingStateAdapter()
        )

        recyclerView.adapter = movieAdapter
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            movieViewModel.loadMovies().collectLatest { pagingData ->
                movieAdapter.submitData(pagingData)
            }
        }
    }
}