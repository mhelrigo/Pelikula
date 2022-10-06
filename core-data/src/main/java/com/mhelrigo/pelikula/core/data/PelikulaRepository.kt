package com.mhelrigo.pelikula.core.data

import androidx.paging.PagingSource
import com.mhelrigo.pelikula.core.model.*
import kotlinx.coroutines.flow.Flow

interface PelikulaRepository  {
    fun getTopRatedMovies(page: Int): Flow<MovieList>
    fun getPopularMovies(page: Int): Flow<MovieList>
    fun getNowPlayingMovies(page: Int): Flow<MovieList>
    fun getMovieDetail(movieId: Int): Flow<MovieDetail>
    fun getMovieCredits(movieId: Int): Flow<Credits>
    fun getMovieImages(movieId: Int): Flow<MovieImages>
    fun getMovieRecommendations(movieId: Int) : Flow<MovieList>
    fun getExpandedMovieList(movieListType: MovieListType): PagingSource<Int, Movie>
}