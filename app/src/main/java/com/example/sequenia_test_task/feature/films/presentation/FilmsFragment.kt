package com.example.sequenia_test_task.feature.films.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sequenia_test_task.databinding.FragmentFilmsBinding
import com.example.sequenia_test_task.feature.films.domain.FilmModel
import org.koin.android.ext.android.inject

class FilmsFragment : Fragment(), FilmView {

    private lateinit var binding: FragmentFilmsBinding
    private val presenter: FilmPresenter by inject()


    private fun initPresenter() {

        //????/
        presenter?.attachView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.filmsRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.filmsRecyclerView.layoutManager = LinearLayoutManager(context)
        initPresenter()
        presenter.getFilms()


        binding.filmsRecyclerView.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

            }

        })

    }


    override suspend fun showFilm(films: List<FilmModel>) {

        val adapter = FilmsRecyclerAdapter()
        binding.filmsRecyclerView.adapter = adapter
        //добавил заголовок жанры
        val resultList: MutableList<ListItem> = mutableListOf()
        resultList.add(ListItem.HeadingGenres)
        //добавил сами жанры
        val genresList: MutableList<ListItem> = mutableListOf()

        films.forEach {
            genresList.addAll(it.genres.map {
                ListItem.Genre(
                    genre = it,
                    isActive = false
                )
            })
        }
        resultList.addAll(genresList.distinct())
        //добавил заголовок фильмы
        resultList.add(ListItem.HeadingFilms)
        //добавил сами фильмы
        val filmList = films.map {
            ListItem.FilmItem(
                it.localizedName,
                it.imageUrl
            )
        }
        resultList.addAll(filmList)
        adapter.items = resultList
        adapter.onItemClick = {

            if (it is ListItem.Genre) {
                Toast.makeText(context, "вы нажали на $it", Toast.LENGTH_SHORT).show()
                //состояние
                val genreInRecycler: String = it.genre
                //список фильмов с нужным жанром
                val filmByGenre = films.filter {
                    it.genres.contains(genreInRecycler)
                }
                val filmByGenreToListItem = filmByGenre.map {
                    ListItem.FilmItem(
                        it.localizedName,
                        it.imageUrl
                    )
                }

                if (!it.isActive) {

                    resultList.removeAll(filmList)
                    resultList.addAll(filmByGenreToListItem)
                    adapter.items = resultList
                    it.isActive = true
                } else {

                    resultList.removeAll(filmByGenreToListItem)
                    resultList.addAll(filmList)
                    adapter.items = resultList

                }

            }
        }
    }


    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }
}



