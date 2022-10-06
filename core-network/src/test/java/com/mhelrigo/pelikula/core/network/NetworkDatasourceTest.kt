package com.mhelrigo.pelikula.core.network

import com.mhelrigo.pelikula.core.network.fake.FakeDataSource
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class NetworkDatasourceTest {

    private lateinit var networkDataSource: FakePelikulaNetworkDataSource

    @Before
    fun setUp() {
        networkDataSource = FakePelikulaNetworkDataSource()
    }

    @Test
    fun `top_rated_movies_api_response_serialization_success`() =
        runTest(StandardTestDispatcher()) {
            val result = networkDataSource.getTopRated(1)
            assertEquals(
                FakeDataSource.topRatedMoviesApiResponse.results.first().id,
                result.results.first().id
            )
        }

    @Test
    fun `popular_movies_api_response_serialization_success`() = runTest(StandardTestDispatcher()) {
        val result = networkDataSource.getPopular(1)
        assertEquals(
            FakeDataSource.popularMoviesApiResponse.results.first().id,
            result.results.first().id
        )
    }

    @Test
    fun `latest_movies_api_response_serialization_success`() = runTest(StandardTestDispatcher()) {
        val result = networkDataSource.getNowPlayingMovies(1)
        assertEquals(
            FakeDataSource.nowPlayingMoviesApiResponse.results.first().id,
            result.results.first().id
        )
    }

    @Test
    fun `movie_detail_api_response_serialization_success`() = runTest(StandardTestDispatcher()) {
        val result = networkDataSource.getMovieDetail(500)
        assertEquals(FakeDataSource.movieDetail.id, result.id)
    }

    @Test
    fun `movie_credits_api_response_serialization_success`() = runTest {
        val result = networkDataSource.getMovieCredits(500)
        assertEquals(FakeDataSource.creditsApiResponse.casts[0].id, result.casts[0].id)
    }

    @Test
    fun `movie_images_api_Response_serialization_success`() = runTest {
        val result = networkDataSource.getMovieImages(550)
        assertEquals(FakeDataSource.movieImagesApiResponse.id, result.id)
    }

    @Test
    fun `movie_recommendations_api_response_serialization_success`() = runTest {
        val result = networkDataSource.getMovieRecommendations(550)
        assertEquals(FakeDataSource.movieRecommendationsApiResponse.results[0].id, result.results[0].id)
    }
}