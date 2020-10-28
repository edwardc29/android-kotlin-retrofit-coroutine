package com.carrion.edward.androidkotlinretrofitcoroutine.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.carrion.edward.androidkotlinretrofitcoroutine.BuildConfig
import com.carrion.edward.androidkotlinretrofitcoroutine.R
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MainAdapter(private var movies: List<Movie>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_movie, parent, false
        )
    )

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(movies[position])

    fun addMovies(data: List<Movie>) {
        this.movies = data
    }
}