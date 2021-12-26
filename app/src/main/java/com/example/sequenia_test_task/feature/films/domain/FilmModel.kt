package com.example.sequenia_test_task.feature.films.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmModel(
    val id: Int,
    val localizedName: String,
    val name: String,
    val year: Int,
    val rating: Double,
    val imageUrl: String?,
    val description: String,
    val genres: List<String>,

    ): Parcelable