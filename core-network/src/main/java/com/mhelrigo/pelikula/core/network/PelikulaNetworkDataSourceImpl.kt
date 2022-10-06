package com.mhelrigo.pelikula.core.network

import com.mhelrigo.pelikula.core.network.model.*
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

    override suspend fun getTopRated(page: Int): MovieListApiResponse {
        return pelikulaApi.getTopRated(page = page)
    }

    override suspend fun getPopular(page: Int): MovieListApiResponse {
        return pelikulaApi.getPopular(page = page)
    }

    override suspend fun getNowPlayingMovies(page: Int): MovieListApiResponse {
        return pelikulaApi.getNowPlaying(page = page)
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetailApiResponse {
        return pelikulaApi.getMovieDetail(movieId = movieId)
    }

    override suspend fun getMovieCredits(movieId: Int): CreditsApiResponse {
        return pelikulaApi.getCredits(movieId = movieId)
    }

    override suspend fun getMovieImages(movieId: Int): MovieImagesApiResponse {
        return pelikulaApi.getMovieImages(movieId = movieId)
    }

    override suspend fun getMovieRecommendations(movieId: Int) : MovieListApiResponse {
        return pelikulaApi.getMovieRecommendations(movieId = movieId)
    }
}