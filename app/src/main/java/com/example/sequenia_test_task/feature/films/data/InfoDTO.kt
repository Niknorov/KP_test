package com.example.sequenia_test_task.feature.films.data

import com.google.gson.annotations.SerializedName

data class InfoDTO(


    @SerializedName("id") val id: Int,
    @SerializedName("localized_name") val localizedName: String,
    @SerializedName("name") val name: String,
    @SerializedName("year") val year: Int,
    @SerializedName("rating") val rating: Double,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("genres") val genres: List<String>,

    )

data class FilmsDTO(
    @SerializedName("films") val films: List<InfoDTO>

)