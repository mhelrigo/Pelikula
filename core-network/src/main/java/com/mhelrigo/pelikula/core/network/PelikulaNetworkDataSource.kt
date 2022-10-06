package com.mhelrigo.pelikula.core.network

import com.mhelrigo.pelikula.core.network.model.*

interface PelikulaNetworkDataSource {
    suspend fun getTopRated(page: Int): MovieListApiResponse
    suspend fun getPopular(page: Int): MovieListApiResponse
    suspend fun getNowPlayingMovies(page: Int): MovieListApiResponse
    suspend fun getMovieDetail(movieId: Int): MovieDetailApiResponse
    suspend fun getMovieCredits(movieId: Int): CreditsApiResponse
    suspend fun getMovieImages(movieId: Int): MovieImagesApiResponse
    suspend fun getMovieRecommendations(movieId: Int) : MovieListApiResponse
}