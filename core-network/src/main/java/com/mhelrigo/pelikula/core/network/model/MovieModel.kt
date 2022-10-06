package com.mhelrigo.pelikula.core.network.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    val id: Int,
    @SerializedName("vote_count")
    val voteCount: Int,
    val popularity: Float,
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("genre_ids")
    val genreIds : List<Int>,
    @SerializedName("backdrop_path")
    val backDropPath: String? = null,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val adult: Boolean,
    val video: Boolean
)