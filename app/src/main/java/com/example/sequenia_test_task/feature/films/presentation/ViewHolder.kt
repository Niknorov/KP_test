package com.example.sequenia_test_task.feature.films.presentation

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.example.sequenia_test_task.R
import com.example.sequenia_test_task.databinding.FilmItemBinding
import com.example.sequenia_test_task.databinding.GenreBinding
import com.example.sequenia_test_task.databinding.HeadingFilmsItemBinding
import com.example.sequenia_test_task.databinding.HeadingGenresItemBinding
import com.squareup.picasso.Picasso

class FilmViewHolder(
    private val filmItemBinding: FilmItemBinding
) : RecyclerView.ViewHolder(filmItemBinding.root) {

    fun bind(filmItem: ListItem.FilmItem) {
        Picasso.get().load(filmItem.image).into(filmItemBinding.image)
        filmItemBinding.localizedName.text = filmItem.localizedName
    }

}

class GenreViewHolder(
    private val genreBinding: GenreBinding
) : RecyclerView.ViewHolder(genreBinding.root) {

    fun bind(genreItem: ListItem.Genre) {
        if (genreItem.isActive) {
            genreBinding.genre.setBackgroundColor(Color.parseColor("#89CFEF"))
            genreBinding.genre.text = genreItem.genre
        } else {
            genreBinding.genre.setBackgroundColor(Color.parseColor("#303030"))
            genreBinding.genre.text = genreItem.genre
        }

    }

}

class HeadingFilmsHolder(
    private val headingFilmsItemBinding: HeadingFilmsItemBinding
) : RecyclerView.ViewHolder(headingFilmsItemBinding.root) {

    fun bind() {
        headingFilmsItemBinding.headingFilms.setText(R.string.films)
    }
}

class HeadingGenresHolder(
    private val headingGenresItemBinding: HeadingGenresItemBinding
) : RecyclerView.ViewHolder(headingGenresItemBinding.root) {

    fun bind() {
        headingGenresItemBinding.headingGenres.setText(R.string.genres)
    }
}