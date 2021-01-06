package com.carrion.edward.androidkotlinretrofitcoroutine.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.carrion.edward.androidkotlinretrofitcoroutine.R
import kotlinx.android.synthetic.main.item_loading.view.*

class LoadingStateAdapter : LoadStateAdapter<LoadingStateAdapter.LoadingStateViewHolder>() {
    override fun onBindViewHolder(holder: LoadingStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadingStateViewHolder = LoadingStateViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_loading, parent, false)
    )

    class LoadingStateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(loadState: LoadState) {
            itemView.apply {
                progressBar.isVisible = loadState is LoadState.Loading
            }
        }
    }
}