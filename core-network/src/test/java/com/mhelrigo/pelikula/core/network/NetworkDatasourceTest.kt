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
    fun `top_rated_movies_api_response_serialization_success`() = runTest(StandardTestDispatcher()) {
        val result = networkDataSource.getTopRated(1)
        assertEquals(FakeDataSource.topRatedMoviesApiResponse.results.first().id, result.results.first().id)
    }

    @Test
    fun `popular_movies_api_response_serialization_success`() = runTest(StandardTestDispatcher()) {
        val result = networkDataSource.getPopular(1)
        assertEquals(FakeDataSource.popularMoviesApiResponse.results.first().id, result.results.first().id)
    }

    @Test
    fun `latest_movies_api_response_serialization_success`() = runTest(StandardTestDispatcher()) {
        val result = networkDataSource.getNowPlayingMovies(1)
        assertEquals(FakeDataSource.nowPlayingMoviesApiResponse.results.first().id, result.results.first().id)
    }
}