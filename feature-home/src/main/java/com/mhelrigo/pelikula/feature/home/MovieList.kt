package com.mhelrigo.pelikula.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mhelrigo.pelikula.core.designsystem.theme.Orange1
import com.mhelrigo.pelikula.core.model.Movie
import com.mhelrigo.pelikula.core.model.MovieListType
import com.mhelrigo.pelikula.core.designsystem.dp
import com.mhelrigo.pelikula.core.ui.*

@Composable
fun MovieList(
    modifier: Modifier = Modifier,
    topRatedMoviesUiState: MoviesUiState,
    popularMoviesUiState: MoviesUiState,
    nowPlayingMoviesUiState: MoviesUiState,
    expandMovie: (movie: Movie) -> Unit,
    expandMovieList: (type: MovieListType) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        PelikulaText(
            text = "Movies",
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            fontWeight = FontWeight.Medium,
            fontSize = 24.dp()
        )
        VerticalColoredLine(
            modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
            color = Orange1
        )
        Column {
            MovieListItem(
                pelikulaRowTitleText = {
                    CategoryText(text = "Being watched")
                },
                pelikulaRowSubTitleText = {
                    MoreText(
                        expandMovieList = expandMovieList,
                        movieListType = MovieListType.NOW_PLAYING
                    )
                },
                moviesUiState = nowPlayingMoviesUiState,
                expandMovie = expandMovie
            )
            MovieListItem(
                pelikulaRowTitleText = {
                    CategoryText(text = "Popular Now")
                },
                pelikulaRowSubTitleText = {
                    MoreText(
                        expandMovieList = expandMovieList,
                        movieListType = MovieListType.POPULAR
                    )
                },
                moviesUiState = popularMoviesUiState,
                expandMovie = expandMovie
            )
            MovieListItem(
                pelikulaRowTitleText = {
                    CategoryText(text = "All time favorites")
                },
                pelikulaRowSubTitleText = {
                    MoreText(
                        expandMovieList = expandMovieList,
                        movieListType = MovieListType.TOP_RATED
                    )
                },
                moviesUiState = topRatedMoviesUiState,
                expandMovie = expandMovie
            )
        }
    }
}

@Composable
fun MovieListItem(
    pelikulaRowTitleText: @Composable () -> Unit,
    pelikulaRowSubTitleText: @Composable () -> Unit,
    moviesUiState: MoviesUiState,
    expandMovie: (movie: Movie) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            pelikulaRowTitleText()
            pelikulaRowSubTitleText()
        }
        when (moviesUiState) {
            is MoviesUiState.Loading -> {
                PelikulaLoading(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(24.dp)
                )
            }
            is MoviesUiState.Error -> {
                PelikulaError(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    message = moviesUiState.message
                )
            }
            is MoviesUiState.Success -> {
                MovieCards(modifier = Modifier, moviesUiState.movies,
                    expandMovie = { movie -> expandMovie(movie) })
            }
        }
    }
}

@Composable
fun CategoryText(text: String) {
    PelikulaText(
        modifier = Modifier.padding(8.dp),
        text = text,
        fontWeight = FontWeight.Medium,
        fontSize = 16.dp(),
    )
}

@Composable
fun MoreText(expandMovieList: (type: MovieListType) -> Unit, movieListType: MovieListType) {
    PelikulaText(
        modifier = Modifier
            .clickable {
                expandMovieList(movieListType)
            }
            .padding(8.dp),
        text = "More",
        fontWeight = FontWeight.Normal,
        fontSize = 16.dp(),
        color = Orange1
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCard(modifier: Modifier = Modifier, movie: Movie, expandMovie: (Movie) -> Unit) {
    Card(
        modifier = modifier
            .widthIn(64.dp),
        elevation = CardDefaults.cardElevation(),
        onClick = {
            expandMovie(movie)
        }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://image.tmdb.org/t/p/original${movie.posterPath}")
                .crossfade(enable = true)
                .build(),
            contentDescription = movie.title,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun MovieCards(modifier: Modifier = Modifier, movies: List<Movie>, expandMovie: (movie: Movie) -> Unit) {
    LazyRow(modifier = modifier.fillMaxWidth()) {
        items(items = movies, key = { item: Movie -> item.id }) { movie ->
            MovieCard(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .widthIn(64.dp)
                    .height(100.dp), movie = movie,
                expandMovie = { expandMovie(it) }
            )
        }
    }
}