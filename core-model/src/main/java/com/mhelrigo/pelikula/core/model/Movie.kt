package com.mhelrigo.pelikula.core.model

data class Movie(val id: Int,
                 val voteCount: Int,
                 val popularity: Float,
                 val voteAverage: Float,
                 val genreIds : List<Int>,
                 val backDropPath: String,
                 val originalLanguage: String,
                 val originalTitle: String,
                 val overview: String,
                 val posterPath: String,
                 val releaseDate: String,
                 val title: String,
                 val adult: Boolean,
                 val video: Boolean) {
}