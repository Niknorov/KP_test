package com.example.sequenia_test_task.feature.films.presentation

import com.example.sequenia_test_task.feature.films.domain.FilmModel

interface FilmView {


    suspend fun showFilm(films: List<FilmModel>)
    fun showError()
}