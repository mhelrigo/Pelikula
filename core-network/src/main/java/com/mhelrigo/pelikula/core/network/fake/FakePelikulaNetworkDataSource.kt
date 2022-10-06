package com.mhelrigo.pelikula.core.network.fake

import com.mhelrigo.pelikula.core.network.PelikulaNetworkDataSource
import com.mhelrigo.pelikula.core.network.model.*

class FakePelikulaNetworkDataSource : PelikulaNetworkDataSource {
    override suspend fun getTopRated(page: Int): MovieListApiResponse {
        return FakeDataSource.topRatedMoviesApiResponse
    }

    override suspend fun getPopular(page: Int): MovieListApiResponse {
        return FakeDataSource.popularMoviesApiResponse
    }

    override suspend fun getNowPlayingMovies(page: Int): MovieListApiResponse {
        return FakeDataSource.nowPlayingMoviesApiResponse
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetailApiResponse {
        return FakeDataSource.movieDetail
    }

    override suspend fun getMovieCredits(movieId: Int): CreditsApiResponse {
        return FakeDataSource.creditsApiResponse
    }

    override suspend fun getMovieImages(movieId: Int): MovieImagesApiResponse {
        return FakeDataSource.movieImagesApiResponse
    }

    override suspend fun getMovieRecommendations(movieId: Int): MovieListApiResponse {
        return FakeDataSource.movieRecommendationsApiResponse
    }
}