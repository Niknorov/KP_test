package com.example.sequenia_test_task.feature.films.domain

interface FilmRepository {

    suspend fun getFilm(): List<FilmModel>
}