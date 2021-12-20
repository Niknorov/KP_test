package com.example.sequenia_test_task.feature.films.di

import com.example.sequenia_test_task.feature.films.data.FilmApi
import com.example.sequenia_test_task.feature.films.data.FilmRemoteDataSource
import com.example.sequenia_test_task.feature.films.data.FilmRepositoryImpl
import com.example.sequenia_test_task.feature.films.domain.FilmRepository
import com.example.sequenia_test_task.feature.films.domain.GetFilmUseCase
import org.koin.dsl.module
import retrofit2.Retrofit

val filmsModule = module {
    single { createFilmApi(get()) }
    single { FilmRemoteDataSource(get()) }
    single<FilmRepository> { return@single FilmRepositoryImpl(get()) }
    single { GetFilmUseCase(get()) }

}

fun createFilmApi(retrofit: Retrofit): FilmApi {
    return retrofit.create(FilmApi::class.java)
}