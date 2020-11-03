package com.carrion.edward.androidkotlinretrofitcoroutine.view.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.carrion.edward.androidkotlinretrofitcoroutine.R
import com.carrion.edward.androidkotlinretrofitcoroutine.view.adapter.MainAdapter
import com.carrion.edward.androidkotlinretrofitcoroutine.view.base.BaseActivity
import com.carrion.edward.androidkotlinretrofitcoroutine.view.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var adapter: MainAdapter

    override fun getLayout() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()
        setupObservers()
    }

    override fun onResume() {
        super.onResume()

        viewModel.loadUsers(1)
    }

    private fun setupUI() {
        adapter = MainAdapter(viewModel.users.value?.results ?: emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
    }

    private fun setupObservers() {
        viewModel.users.observe(this, Observer {
            errorTextView.visibility = View.GONE
            emptyTextView.visibility = View.GONE

            adapter.apply {
                addMovies(it.results)
                notifyDataSetChanged()
            }
        })

        viewModel.isViewLoading.observe(this, Observer {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.onMessageError.observe(this, Observer {
            errorTextView.visibility = View.VISIBLE
            emptyTextView.visibility = View.GONE
            errorTextView.text = "Error $it"
        })

        viewModel.isEmptyList.observe(this, Observer {
            emptyTextView.visibility = View.VISIBLE
            errorTextView.visibility = View.GONE
        })
    }
}