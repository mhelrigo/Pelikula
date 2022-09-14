package com.mhelrigo.pelikula.core.network

import com.mhelrigo.pelikula.core.network.model.NowPlayingMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.PopularMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.TopRatedMoviesApiResponse

interface PelikulaNetworkDataSource {
    suspend fun getTopRated(page: Int): TopRatedMoviesApiResponse
    suspend fun getPopular(page: Int): PopularMoviesApiResponse
    suspend fun getNowPlayingMovies(page: Int): NowPlayingMoviesApiResponse
}