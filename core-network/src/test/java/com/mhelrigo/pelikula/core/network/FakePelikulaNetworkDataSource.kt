package com.mhelrigo.pelikula.core.network

import com.mhelrigo.pelikula.core.network.fake.movieDetailApiResponse
import com.mhelrigo.pelikula.core.network.fake.movieRecommendationApiResponse
import com.mhelrigo.pelikula.core.network.fake.popularMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.*
import com.mhelrigo.pelikula.core.network.retrofit.FakeRetrofit
import com.mhelrigo.pelikula.core.network.retrofit.PelikulaApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit

internal class FakePelikulaNetworkDataSource : PelikulaNetworkDataSource {

    val mockWebServer = MockWebServer()
    var retrofit : Retrofit = FakeRetrofit.fakeServer(mockWebServer)
    var pelikulaApi: PelikulaApi = retrofit.create(PelikulaApi::class.java)
    val fakeResponse = FakeRetrofit.fakeResponse

    override suspend fun getTopRated(page: Int): MovieListApiResponse {
        return withContext(Dispatchers.IO) {
            fakeResponse.setResponseCode(200).setBody(popularMoviesApiResponse)
            mockWebServer.enqueue(fakeResponse)
            pelikulaApi.getTopRated(page)
        }
    }

    override suspend fun getPopular(page: Int): MovieListApiResponse {
        return withContext(Dispatchers.IO) {
            fakeResponse.setResponseCode(200).setBody(popularMoviesApiResponse)
            mockWebServer.enqueue(fakeResponse)
            pelikulaApi.getPopular(page)
        }
    }

    override suspend fun getNowPlayingMovies(page: Int): MovieListApiResponse {
        return withContext(Dispatchers.IO) {
            fakeResponse.setResponseCode(200).setBody(popularMoviesApiResponse)
            mockWebServer.enqueue(fakeResponse)
            pelikulaApi.getNowPlaying(page)
        }
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetailApiResponse {
        return withContext(Dispatchers.IO) {
            fakeResponse.setResponseCode(200).setBody(movieDetailApiResponse)
            mockWebServer.enqueue(fakeResponse)
            pelikulaApi.getMovieDetail(500)
        }
    }

    override suspend fun getMovieCredits(movieId: Int): CreditsApiResponse {
        return withContext(Dispatchers.IO) {
            fakeResponse.setResponseCode(200).setBody(com.mhelrigo.pelikula.core.network.fake.creditsApiResponse)
            mockWebServer.enqueue(fakeResponse)
            pelikulaApi.getCredits(500)
        }
    }

    override suspend fun getMovieImages(movieId: Int): MovieImagesApiResponse {
        return withContext(Dispatchers.IO) {
            fakeResponse.setResponseCode(200).setBody(com.mhelrigo.pelikula.core.network.fake.movieiMagesApiResponse)
            mockWebServer.enqueue(fakeResponse)
            pelikulaApi.getMovieImages(550)
        }
    }

    override suspend fun getMovieRecommendations(movieId: Int) : MovieListApiResponse {
        return withContext(Dispatchers.IO) {
            fakeResponse.setResponseCode(200).setBody(movieRecommendationApiResponse)
            mockWebServer.enqueue(fakeResponse)
            pelikulaApi.getMovieRecommendations(550)
        }
    }
}