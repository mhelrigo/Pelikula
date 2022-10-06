package com.mhelrigo.pelikula.core.network.model

import com.google.gson.annotations.SerializedName

data class MovieDetailApiResponse(
    val id: Int,
    val budget: Int,
    val revenue: Int,
    val runtime: Int,
    @SerializedName("vote_count")
    val voteCount: Int,
    val popularity: Float,
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("release_date")
    val releaseDate: String,
    val status: String,
    val tagline: String,
    val title: String,
    val genres: List<GenreModel> = emptyList(),
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompanyModel>,
    @SerializedName("production_countries") val productionCountries: List<ProductionCountryModel>,
    @SerializedName("spoken_languages") val spokenLanguageModels: List<SpokenLanguageModel>
)

data class ProductionCompanyModel(
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: String? = null,
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String
)

data class ProductionCountryModel(@SerializedName("iso_3166_1") val iso: String, val name: String)

data class SpokenLanguageModel(@SerializedName("iso_639_1") val iso: String, val name: String)

data class GenreModel(val id: Int, val name: String)