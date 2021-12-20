package com.example.sequenia_test_task.feature.films.domain

data class FilmModel(


    val id: Int,
    val localizedName: String,
    val name: String,
    val year: Int,
    val rating: Double,
    val imageUrl: String,
    val description: String,
    val genres: String,

    )