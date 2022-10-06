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
                movies.results.first().id,
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
                movies.results.first().id,
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
                movies.results.first().id,
                fakeNetworkDataSourceImpl.getNowPlayingMovies(
                    page = 1
                ).results.first().id
            )
        }
    }

    @Test
    fun `movie_detail_came_from_a_remote_data_source`() {
        runTest {
            val movieDetail = pelikulaRepositoryImpl.getMovieDetail(550)

            assertEquals(movieDetail.first().id, fakeNetworkDataSourceImpl.getMovieDetail(550).id)
        }
    }

    @Test
    fun `movie_credit_came_from_a_remote_data_source`() {
        runTest {
            val movieCredit = pelikulaRepositoryImpl.getMovieCredits(550)

            assertEquals(
                movieCredit.first().casts[0].id,
                fakeNetworkDataSourceImpl.getMovieCredits(550).casts[0].id
            )
        }
    }

    @Test
    fun `movie_images_came_from_a_remote_data_source`() {
        runTest {
            val movieImages = pelikulaRepositoryImpl.getMovieImages(550)

            assertEquals(
                movieImages.first().id,
                fakeNetworkDataSourceImpl.getMovieImages(550).id
            )
        }
    }

    @Test
    fun `movie_recommendation_came_from_a_remote_data_source`() {
        runTest {
            val movieRecommendations = pelikulaRepositoryImpl.getMovieRecommendations(550)

            assertEquals(
                movieRecommendations.first().results[0].id,
                fakeNetworkDataSourceImpl.getMovieRecommendations(550).results[0].id
            )
        }
    }
}