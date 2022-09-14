package com.mhelrigo.pelikula.core.network

import com.mhelrigo.pelikula.core.network.fake.popularMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.NowPlayingMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.PopularMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.TopRatedMoviesApiResponse
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

    override suspend fun getTopRated(page: Int): TopRatedMoviesApiResponse {
        return withContext(Dispatchers.IO) {
            fakeResponse.setResponseCode(200).setBody(popularMoviesApiResponse)
            mockWebServer.enqueue(fakeResponse)
            pelikulaApi.getTopRated(page)
        }
    }

    override suspend fun getPopular(page: Int): PopularMoviesApiResponse {
        return withContext(Dispatchers.IO) {
            fakeResponse.setResponseCode(200).setBody(popularMoviesApiResponse)
            mockWebServer.enqueue(fakeResponse)
            pelikulaApi.getPopular(page)
        }
    }

    override suspend fun getNowPlayingMovies(page: Int): NowPlayingMoviesApiResponse {
        return withContext(Dispatchers.IO) {
            fakeResponse.setResponseCode(200).setBody(popularMoviesApiResponse)
            mockWebServer.enqueue(fakeResponse)
            pelikulaApi.getNowPlaying(page)
        }
    }
}