package com.mhelrigo.pelikula.core.network.fake

import com.mhelrigo.pelikula.core.network.PelikulaNetworkDataSource
import com.mhelrigo.pelikula.core.network.model.NowPlayingMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.PopularMoviesApiResponse
import com.mhelrigo.pelikula.core.network.model.TopRatedMoviesApiResponse

class FakePelikulaNetworkDataSource: PelikulaNetworkDataSource {
    override suspend fun getTopRated(page: Int): TopRatedMoviesApiResponse {
        return FakeDataSource.topRatedMoviesApiResponse
    }

    override suspend fun getPopular(page: Int): PopularMoviesApiResponse {
        return FakeDataSource.popularMoviesApiResponse
    }

    override suspend fun getNowPlayingMovies(page: Int): NowPlayingMoviesApiResponse {
        return FakeDataSource.nowPlayingMoviesApiResponse
    }
}