package com.example.sequenia_test_task.feature.films.data

import retrofit2.http.GET

interface FilmApi {

    @GET(value = "films.json")
    suspend fun getFilm() : List<InfoDTO>
}