package com.mhelrigo.pelikula.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mhelrigo.pelikula.core.model.Movie
import com.mhelrigo.pelikula.core.ui.Loading
import com.mhelrigo.pelikula.core.ui.MovieScreen
import com.mhelrigo.pelikula.core.ui.Error

@Composable
fun HomeScreen(
    modifier: Modifier,
    topRatedMoviesUiState: MoviesUiState,
    popularMoviesUiState: MoviesUiState,
    nowPlayingMoviesUiState: MoviesUiState
) {
    Column(modifier = modifier) {
        Text("Being watched")
        NowPlayingMovies(nowPlayingMoviesUiState)
        Text("Popular Now")
        PopularMovies(popularMoviesUiState)
        Text("All time favorites")
        TopRatedMovies(topRatedMoviesUiState)
    }
}

@Composable
fun TopRatedMovies(topRatedMoviesUiState: MoviesUiState) =
    when (topRatedMoviesUiState) {
        is MoviesUiState.Loading -> {
            Loading(modifier = Modifier)
        }
        is MoviesUiState.Error -> {
            Error(modifier = Modifier)
        }
        is MoviesUiState.Success -> {
            Movies(modifier = Modifier, topRatedMoviesUiState.movies)
        }
    }

@Composable
fun PopularMovies(popularMoviesUiState: MoviesUiState) =
    when (popularMoviesUiState) {
        is MoviesUiState.Loading -> {
            Loading(modifier = Modifier)
        }
        is MoviesUiState.Error -> {
            Error(modifier = Modifier)
        }
        is MoviesUiState.Success -> {
            Movies(modifier = Modifier, popularMoviesUiState.movies)
        }
    }

@Composable
fun NowPlayingMovies(nowPlayingMoviesUiState: MoviesUiState) =
    when (nowPlayingMoviesUiState) {
        is MoviesUiState.Loading -> {
            Loading(modifier = Modifier)
        }
        is MoviesUiState.Error -> {
            Error(modifier = Modifier)
        }
        is MoviesUiState.Success -> {
            Movies(modifier = Modifier, nowPlayingMoviesUiState.movies)
        }
    }

@Composable
fun Movies(modifier: Modifier, movies: List<Movie>) {
    LazyRow {
        items(items = movies, key = { item: Movie -> item.id }) { movie ->
            MovieScreen(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .widthIn(64.dp)
                    .height(100.dp), movie = movie
            )
        }
    }
}

