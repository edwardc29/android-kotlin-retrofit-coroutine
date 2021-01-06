package com.carrion.edward.androidkotlinretrofitcoroutine.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.carrion.edward.androidkotlinretrofitcoroutine.BuildConfig
import com.carrion.edward.androidkotlinretrofitcoroutine.R
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter : PagingDataAdapter<Movie, MovieAdapter.MovieViewHolder>((MovieDiffUtil)) {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            itemView.apply {
                titleTextView.text = movie.title
                releaseDateTextView.text = movie.releaseDate
                voteTextView.text = movie.vote.toString()

                posterImageView.load(BuildConfig.BASE_URL_IMAGE.plus(movie.posterPath)) {
                    crossfade(true)
                    placeholder(R.mipmap.ic_launcher_round)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
    )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    object MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}