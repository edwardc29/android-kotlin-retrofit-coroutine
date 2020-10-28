package com.carrion.edward.androidkotlinretrofitcoroutine.view.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.carrion.edward.androidkotlinretrofitcoroutine.R
import com.carrion.edward.androidkotlinretrofitcoroutine.di.Injection
import com.carrion.edward.androidkotlinretrofitcoroutine.view.adapter.MainAdapter
import com.carrion.edward.androidkotlinretrofitcoroutine.view.base.ViewModelFactory
import com.carrion.edward.androidkotlinretrofitcoroutine.view.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
    }

    override fun onResume() {
        super.onResume()

        viewModel.loadUsers(1)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(Injection.providerRepository())
        ).get(MainViewModel::class.java)
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