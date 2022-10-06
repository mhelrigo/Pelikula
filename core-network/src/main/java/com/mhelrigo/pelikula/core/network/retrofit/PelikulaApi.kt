package com.mhelrigo.pelikula.core.network.retrofit

import com.mhelrigo.pelikula.core.network.BuildConfig
import com.mhelrigo.pelikula.core.network.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PelikulaApi {
    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): MovieListApiResponse

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): MovieListApiResponse

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): MovieListApiResponse

    @GET("movie/{movieId}")
    suspend fun getMovieDetail(
        @Path(value = "movieId", encoded = true) movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): MovieDetailApiResponse

    @GET("movie/{movieId}/credits")
    suspend fun getCredits(
        @Path(value = "movieId", encoded = true) movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): CreditsApiResponse

    @GET("movie/{movieId}/images")
    suspend fun getMovieImages(
        @Path(value = "movieId", encoded = true) movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): MovieImagesApiResponse

    @GET("movie/{movieId}/recommendations")
    suspend fun getMovieRecommendations(
        @Path(value = "movieId", encoded = true) movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : MovieListApiResponse
}