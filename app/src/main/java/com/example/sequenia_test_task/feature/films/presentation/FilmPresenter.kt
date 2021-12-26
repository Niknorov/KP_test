package com.example.sequenia_test_task.feature.films.presentation

import com.example.sequenia_test_task.feature.films.domain.GetFilmUseCase
import kotlinx.coroutines.*
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.coroutines.CoroutineContext

class FilmPresenter(
    private val getFilmUseCase: GetFilmUseCase,
) : CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    private var view: FilmView? = null

    fun getFilms() {

        launch {
            try {
                val films = getFilmUseCase()
                withContext(Dispatchers.Main) {
                    view?.showFilm(films)
                }
            } catch (unknownHostException: UnknownHostException) {
                withContext(Dispatchers.Main) {
                    view?.showError()
                }

            } catch (socketTimeoutException: SocketTimeoutException) {
                withContext(Dispatchers.Main) {
                    view?.showError()
                }
            }
        }


    }


    fun attachView(view: FilmView) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

}