package com.mhelrigo.pelikula.core.network

import com.mhelrigo.pelikula.core.network.model.NowPlayingMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.PopularMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.TopRatedMoviesApiResponse
import com.mhelrigo.pelikula.core.network.retrofit.PelikulaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class PelikulaNetworkDataSourceImpl @Inject constructor() :
    PelikulaNetworkDataSource {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org/3/")
        .build()

    private val pelikulaApi = retrofit.create(PelikulaApi::class.java)

    override suspend fun getTopRated(page: Int): TopRatedMoviesApiResponse {
        return pelikulaApi.getTopRated(page = page)
    }

    override suspend fun getPopular(page: Int): PopularMoviesApiResponse {
        return pelikulaApi.getPopular(page = page)
    }

    override suspend fun getNowPlayingMovies(page: Int): NowPlayingMoviesApiResponse {
        return pelikulaApi.getNowPlaying(page = page)
    }
}