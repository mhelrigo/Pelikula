package com.mhelrigo.pelikula.feature.expandedmovielist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mhelrigo.pelikula.core.model.Movie
import com.mhelrigo.pelikula.core.designsystem.dp
import com.mhelrigo.pelikula.core.ui.*
import kotlinx.coroutines.flow.Flow

@Composable
fun ExpandedMovieListRoute(
    modifier: Modifier = Modifier,
    expandedMovieListViewModel: ExpandedMovieListViewModel = hiltViewModel(),
    onBackPressed: () -> Unit,
    expandMovie: (movie: Movie) -> Unit,
) {
    ExpandedMovieListScreen(
        expandedMovieListTypeName = expandedMovieListViewModel.expandedMovieListTypeName,
        onBackPressed = onBackPressed,
        expandMovie = expandMovie,
        pagingDataMovie = expandedMovieListViewModel.movieList
    )
}

@Composable
fun ExpandedMovieListScreen(
    modifier: Modifier = Modifier,
    expandedMovieListTypeName: String,
    onBackPressed: () -> Unit,
    expandMovie: (movie: Movie) -> Unit,
    pagingDataMovie: Flow<PagingData<Movie>>
) {
    Column(modifier = modifier) {
        TopBar(
            expandedMovieListTypeName = expandedMovieListTypeName,
            onBackPressed = onBackPressed
        )
        Spacer(modifier = Modifier.height(8.dp))
        MovieList(
            expandMovie = expandMovie,
            pagingDataMovie = pagingDataMovie
        )
    }
}

@Composable
fun TopBar(
    expandedMovieListTypeName: String,
    onBackPressed: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = "back",
            tint = Color.Black,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.TopStart)
                .clickable {
                    onBackPressed()
                },
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.Start
        ) {
            PelikulaText(
                text = expandedMovieListTypeName,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                fontWeight = FontWeight.Medium,
                fontSize = 16.dp(),
                textAlign = TextAlign.Center
            )
            VerticalColoredLine(modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Composable
fun MovieList(
    modifier: Modifier = Modifier,
    expandMovie: (movie: Movie) -> Unit,
    pagingDataMovie: Flow<PagingData<Movie>>
) {
    val movies: LazyPagingItems<Movie> = pagingDataMovie.collectAsLazyPagingItems()

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(movies.itemCount) {
                MovieItem(
                    modifier = Modifier
                        .padding(8.dp)
                        .height(100.dp),
                    expandMovie = expandMovie,
                    movie = movies[it]!!
                )
            }
        }

        movies.apply {
            when {
                loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        PelikulaLoading(
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .padding(32.dp)
                        )
                    }
                }

                loadState.append is LoadState.Error || loadState.refresh is LoadState.Error -> {
                    PelikulaError(
                        modifier = Modifier.align(Alignment.Center),
                        message = "Something went wrong."
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieItem(modifier: Modifier = Modifier, movie: Movie, expandMovie: (movie: Movie) -> Unit) {
    Row(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .width(80.dp)
                .padding(start = 8.dp),
            elevation = CardDefaults.cardElevation(),
            onClick = {
                expandMovie(movie)
            }
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://image.tmdb.org/t/p/original${movie.backDropPath}")
                    .crossfade(enable = true)
                    .build(),
                contentDescription = movie.backDropPath,
                contentScale = ContentScale.FillHeight
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            PelikulaText(
                text = movie.title,
                modifier = Modifier,
                fontWeight = FontWeight.Medium,
                fontSize = 12.dp(),
            )
            StarRating(
                rating = movie.voteAverage / 2,
                starCount = 5,
                trackColor = Color.LightGray
            )
        }
    }
}