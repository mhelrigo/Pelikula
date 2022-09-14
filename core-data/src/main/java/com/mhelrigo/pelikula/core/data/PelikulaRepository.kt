package com.mhelrigo.pelikula.core.data

import com.mhelrigo.pelikula.core.model.Movie
import kotlinx.coroutines.flow.Flow

interface PelikulaRepository  {
    fun getTopRatedMovies(page: Int): Flow<List<Movie>>
    fun getPopularMovies(page: Int): Flow<List<Movie>>
    fun getNowPlayingMovies(page: Int): Flow<List<Movie>>
}