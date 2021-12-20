package com.example.sequenia_test_task.feature.films.data

import com.example.sequenia_test_task.feature.films.domain.FilmModel
import com.example.sequenia_test_task.feature.films.domain.FilmRepository

class FilmRepositoryImpl(
    private val filmRemoteDataSource: FilmRemoteDataSource
) : FilmRepository {


    override suspend fun getFilm(): List<FilmModel> {
        return filmRemoteDataSource.getFilm().map {
            FilmModel(
                id = it.id,
                localizedName = it.localizedName,
                name = it.name,
                year = it.year,
                rating = it.rating,
                imageUrl = it.imageUrl,
                description = it.description,
                genres = it.genres,
                )
        }
    }
}