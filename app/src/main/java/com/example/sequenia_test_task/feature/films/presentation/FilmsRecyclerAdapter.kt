package com.example.sequenia_test_task.feature.films.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sequenia_test_task.databinding.FilmItemBinding
import com.example.sequenia_test_task.databinding.GenreBinding
import com.example.sequenia_test_task.databinding.HeadingFilmsItemBinding
import com.example.sequenia_test_task.databinding.HeadingGenresItemBinding
import com.example.sequenia_test_task.feature.films.domain.FilmModel
import java.lang.IllegalArgumentException

class FilmsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private companion object {

        const val FILM_VIEW_TYPE = 0
        const val GENRE_VIEW_TYPE = 1
        const val HEADING_FILMS_VIEW_TYPE = 2
        const val HEADING_GENRES_VIEW_TYPE = 3
    }

    var onItemClick: ((ListItem) -> Unit)? = null

    var items: List<ListItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            FILM_VIEW_TYPE -> {
                FilmViewHolder(
                    FilmItemBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )

            }
            GENRE_VIEW_TYPE -> {
                GenreViewHolder(
                    GenreBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            HEADING_FILMS_VIEW_TYPE -> {
                HeadingFilmsHolder(
                    HeadingFilmsItemBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            HEADING_GENRES_VIEW_TYPE -> {
                HeadingGenresHolder(
                    HeadingGenresItemBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            else -> throw IllegalArgumentException("Wrong view type: $viewType")
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FilmViewHolder -> holder.bind(items[position] as ListItem.FilmItem)
            is GenreViewHolder -> holder.bind(items[position] as ListItem.Genre)
            // is GenreViewHolder -> holder.itemView.setOnClickListener {
            //     onItemClick?.invoke(items[position])
            // }
            is HeadingFilmsHolder -> holder.bind(items[position] as ListItem.HeadingFilms)
            is HeadingGenresHolder -> holder.bind(items[position] as ListItem.HeadingGenres)
        }
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(items[position])
        }

    }

    override fun getItemViewType(position: Int): Int =
        if (items[position] is ListItem.FilmItem) {
            FILM_VIEW_TYPE
        } else if (items[position] is ListItem.Genre) {
            GENRE_VIEW_TYPE
        } else if (items[position] is ListItem.HeadingGenres) {
            HEADING_GENRES_VIEW_TYPE
        } else {
            HEADING_FILMS_VIEW_TYPE
        }

    override fun getItemCount(): Int =
        items.size


}