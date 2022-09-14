package com.mhelrigo.pelikula.core.data

import com.mhelrigo.pelikula.core.network.fake.FakePelikulaNetworkDataSource
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class PelikulaRepositoryTest {

    private lateinit var pelikulaRepositoryImpl: PelikulaRepositoryImpl

    private var fakeNetworkDataSourceImpl = FakePelikulaNetworkDataSource()

    @Before
    fun setUp() {
        pelikulaRepositoryImpl = PelikulaRepositoryImpl(fakeNetworkDataSourceImpl)
    }

    @Test
    fun `top_rated_movies_came_from_a_remote_data_source`() {
        runTest {
            val movies = pelikulaRepositoryImpl.getTopRatedMovies(
                page = 1
            ).first()

            assertEquals(
                movies.first().id,
                fakeNetworkDataSourceImpl.getTopRated(
                    page = 1
                ).results.first().id
            )
        }
    }

    @Test
    fun `popular_movies_came_from_a_remote_data_source`() {
        runTest {
            val movies = pelikulaRepositoryImpl.getTopRatedMovies(
                page = 1
            ).first()

            assertEquals(
                movies.first().id,
                fakeNetworkDataSourceImpl.getPopular(
                    page = 1
                ).results.first().id
            )
        }
    }

    @Test
    fun `latest_movies_came_from_a_remote_data_source`() {
        runTest {
            val movies = pelikulaRepositoryImpl.getNowPlayingMovies(
                page = 1
            ).first()

            assertEquals(
                movies.first().id,
                fakeNetworkDataSourceImpl.getNowPlayingMovies(
                    page = 1
                ).results.first().id
            )
        }
    }
}