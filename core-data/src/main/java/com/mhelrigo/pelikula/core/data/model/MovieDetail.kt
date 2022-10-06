package com.mhelrigo.pelikula.core.data.model

import com.mhelrigo.pelikula.core.model.*
import com.mhelrigo.pelikula.core.network.model.*

fun MovieDetailApiResponse.asEntity() = MovieDetail(
    id = id,
    budget = budget,
    revenue = revenue,
    runtime = runtime,
    voteCount = voteCount,
    popularity = popularity,
    voteAverage = voteAverage,
    backdropPath = backdropPath,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    posterPath = posterPath,
    releaseDate = releaseDate,
    status = status,
    tagline = tagline,
    title = title,
    genres = genres.asEntityGenreModels(),
    productionCompanies = productionCompanies.asEntityProductionCompanyModels(),
    productionCountries = productionCountries.asEntityProductionCountryModels(),
    spokenLanguages = spokenLanguageModels.asEntity()
)

fun ProductionCompanyModel.asEntity() =
    ProductionCompany(id = id, logoPath = logoPath, name = name, originCountry = originCountry)

fun List<ProductionCompanyModel>.asEntityProductionCompanyModels() = this.map {
    it.asEntity()
}

fun ProductionCountryModel.asEntity() =
    ProductionCountry(iso = iso, name = name)

fun List<ProductionCountryModel>.asEntityProductionCountryModels() = this.map {
    it.asEntity()
}

fun SpokenLanguageModel.asEntity() = SpokenLanguage(iso = iso, name = name)

fun List<SpokenLanguageModel>.asEntity() = this.map {
    it.asEntity()
}

fun GenreModel.asEntity() = Genre(id = id, name = name)

fun List<GenreModel>.asEntityGenreModels() = this.map {
    it.asEntity()
}
