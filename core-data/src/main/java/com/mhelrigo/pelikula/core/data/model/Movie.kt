package com.mhelrigo.pelikula.core.data.model

import com.mhelrigo.pelikula.core.model.Movie
import com.mhelrigo.pelikula.core.network.model.MovieModel

fun MovieModel.asEntity() =
    Movie(
        id = id,
        voteCount =
        voteCount,
        popularity = popularity,
        voteAverage = voteAverage,
        genreIds = genreIds,
        backDropPath = backDropPath,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        adult = adult,
        video = video
    )

fun List<MovieModel>.asEntity() = this.map{
    it.asEntity()
}
