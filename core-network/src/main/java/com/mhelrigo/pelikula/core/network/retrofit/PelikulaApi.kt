package com.mhelrigo.pelikula.core.network.retrofit

import com.mhelrigo.pelikula.core.network.BuildConfig
import com.mhelrigo.pelikula.core.network.model.NowPlayingMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.PopularMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.TopRatedMoviesApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PelikulaApi {
    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): TopRatedMoviesApiResponse

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): PopularMoviesApiResponse

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): NowPlayingMoviesApiResponse
}