package com.mhelrigo.pelikula.feature.home

import com.mhelrigo.pelikula.core.data.fake.FakePelikulaRepository
import com.mhelrigo.pelikula.core.testing.MainDispatcherRule
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Before
import org.junit.Rule

class HomeViewModelTest {
    @get:Rule
    private val mainDispatcherRule = MainDispatcherRule()

    private lateinit var homeViewModel: HomeViewModel
    private val fakePelikulaRepository: FakePelikulaRepository = FakePelikulaRepository()

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(pelikulaRepository = fakePelikulaRepository)
    }

    @Test
    fun `get_top_rated_movies_state_is_loading`() = runTest {
        val getTopRatedMoviesJob = launch(UnconfinedTestDispatcher()) {
            homeViewModel.topRatedMoviesState.collect()
        }

        assertTrue(homeViewModel.topRatedMoviesState.value is MoviesUiState.Loading)

        getTopRatedMoviesJob.cancel()
    }

    @Test
    fun `get_popular_movies_state_is_loading`() = runTest {
        val getTopRatedMoviesJob = launch(UnconfinedTestDispatcher()) {
            homeViewModel.popularMoviesState.collect()
        }

        assertTrue(homeViewModel.popularMoviesState.value is MoviesUiState.Loading)

        getTopRatedMoviesJob.cancel()
    }

    @Test
    fun `get_popular_movies_state_is_success`() = runTest {
        val getTopRatedMoviesJob = launch(UnconfinedTestDispatcher()) {
            homeViewModel.topRatedMoviesState.collect()
        }

        fakePelikulaRepository.sendFakeStreamOfData()

        assertTrue(homeViewModel.topRatedMoviesState.value is MoviesUiState.Success)

        getTopRatedMoviesJob.cancel()
    }
}