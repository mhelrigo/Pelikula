package com.mhelrigo.pelikula.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mhelrigo.pelikula.core.model.Movie
import com.mhelrigo.pelikula.core.model.MovieListType

@Composable
fun HomeRoute(
    expandMovie: (movie: Movie) -> Unit,
    expandMovieList: (type: MovieListType) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        topRatedMoviesUiState = homeViewModel.topRatedMoviesState.collectAsState().value,
        popularMoviesUiState = homeViewModel.popularMoviesState.collectAsState().value,
        nowPlayingMoviesUiState = homeViewModel.nowPlayingMoviesState.collectAsState().value,
        expandMovie = expandMovie,
        expandMovieList = expandMovieList
    )
}

@Composable
fun HomeScreen(
    topRatedMoviesUiState: MoviesUiState,
    popularMoviesUiState: MoviesUiState,
    nowPlayingMoviesUiState: MoviesUiState,
    expandMovie: (movie: Movie) -> Unit,
    expandMovieList: (type: MovieListType) -> Unit
) {
    MovieList(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(
                rememberScrollState()
            ),
        topRatedMoviesUiState = topRatedMoviesUiState,
        popularMoviesUiState = popularMoviesUiState,
        nowPlayingMoviesUiState = nowPlayingMoviesUiState,
        expandMovie = expandMovie,
        expandMovieList = expandMovieList
    )
}
