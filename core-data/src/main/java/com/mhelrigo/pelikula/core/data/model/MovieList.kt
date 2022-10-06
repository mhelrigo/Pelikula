package com.mhelrigo.pelikula.core.data.model

import com.mhelrigo.pelikula.core.model.MovieList
import com.mhelrigo.pelikula.core.network.model.MovieListApiResponse

fun MovieListApiResponse.asEntity() = MovieList(
    page = page,
    results = results.asEntity(),
    totalPages = totalPages,
    totalResult = totalResult
)