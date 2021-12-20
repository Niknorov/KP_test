package com.example.sequenia_test_task.feature.films.domain

class GetFilmUseCase(
    private val filmRepository: FilmRepository
) {

    suspend operator fun invoke(): List<FilmModel> {
        return filmRepository.getFilm()
    }
}
