package com.mhelrigo.pelikula.core.model

data class MovieDetail(
    val id: Int,
    val budget: Int,
    val revenue: Int,
    val runtime: Int,
    val voteCount: Int,
    val popularity: Float,
    val voteAverage: Float,
    val backdropPath: String,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val status: String,
    val tagline: String,
    val title: String,
    val genres: List<Genre> = emptyList(),
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val spokenLanguages: List<SpokenLanguage>
) {
}

data class ProductionCompany(
    val id: Int,
    val logoPath: String? = null,
    val name: String,
    val originCountry: String
)

data class ProductionCountry(val iso: String, val name: String)

data class SpokenLanguage(val iso: String, val name: String)

data class Genre(val id: Int, val name: String)