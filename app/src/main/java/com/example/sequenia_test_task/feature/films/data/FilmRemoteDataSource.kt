package com.example.sequenia_test_task.feature.films.data

class FilmRemoteDataSource(
    private val filmApi: FilmApi
) {
    suspend fun getFilm(): FilmsDTO {
        return filmApi.getFilm()
    }
}