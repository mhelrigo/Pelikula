package com.mhelrigo.pelikula.feature.moviedetails

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mhelrigo.pelikula.core.ui.*
import com.mhelrigo.pelikula.core.designsystem.dp

@Composable
fun MovieDetailRoute(
    modifier: Modifier,
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {
    MovieDetailScreen(
        modifier = modifier.fillMaxSize(),
        movieDetailUiState = movieDetailViewModel.movieDetailState.collectAsState().value,
        movieCastUiState = movieDetailViewModel.movieCastUiState.collectAsState().value,
        movieImagesUiState = movieDetailViewModel.movieImagesUiState.collectAsState().value,
        movieRecommendationsUiState = movieDetailViewModel.movieRecommendationsUiState.collectAsState().value,
        onBackPressed = onBackPressed
    )
}

@Composable
fun MovieDetailScreen(
    modifier: Modifier,
    movieDetailUiState: MovieDetailUiState,
    movieCastUiState: MovieCastUiState,
    movieImagesUiState: MovieImagesUiState,
    movieRecommendationsUiState: MovieRecommendationsUiState,
    onBackPressed: () -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            MovieDetails(movieDetailUiState = movieDetailUiState, onBackPressed = onBackPressed)

            Spacer(modifier = Modifier.height(16.dp))
            PelikulaText(
                modifier = Modifier.padding(8.dp),
                text = "Cast",
                fontWeight = FontWeight.Medium,
                fontSize = 16.dp(),
            )
            Casts(movieCastUiState = movieCastUiState)

            Spacer(modifier = Modifier.height(16.dp))
            PelikulaText(
                modifier = Modifier.padding(8.dp),
                text = "Images",
                fontWeight = FontWeight.Medium,
                fontSize = 16.dp(),
            )
            Images(movieImagesUiState = movieImagesUiState)

            Spacer(modifier = Modifier.height(16.dp))
            PelikulaText(
                modifier = Modifier.padding(8.dp),
                text = "Recommendations",
                fontWeight = FontWeight.Medium,
                fontSize = 16.dp(),
            )
            Recommendations(movieRecommendationsUiState = movieRecommendationsUiState)
        }
    }
}

@Composable
fun MovieDetails(
    modifier: Modifier = Modifier,
    movieDetailUiState: MovieDetailUiState,
    onBackPressed: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        when (movieDetailUiState) {
            is MovieDetailUiState.Loading -> {
                PelikulaLoading(
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .padding(32.dp)
                )
            }
            is MovieDetailUiState.Success -> {
                Column {
                    Box {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://image.tmdb.org/t/p/original${movieDetailUiState.movieDetail.backdropPath}")
                                .crossfade(enable = true)
                                .build(),
                            contentDescription = movieDetailUiState.movieDetail.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(250.dp)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .height(250.dp)
                                .fillMaxWidth()
                                .background(color = Color.Black.copy(0.7F))
                        )
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "back",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(8.dp)
                                .align(Alignment.TopStart)
                                .clickable {
                                    onBackPressed()
                                }
                        )
                        Column(modifier = Modifier.align(Alignment.BottomStart)) {
                            PelikulaText(
                                modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                                text = movieDetailUiState.movieDetail.title,
                                color = Color.White,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.dp(),
                            )
                            VerticalColoredLine(
                                modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                                color = Color.White
                            )
                            StarRating(
                                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
                                rating = movieDetailUiState.movieDetail.voteAverage / 2,
                                starCount = 5
                            )
                        }
                    }
                    LazyRow {
                        items(items = movieDetailUiState.movieDetail.genres) {
                            Box(
                                modifier = Modifier.padding(
                                    start = 8.dp,
                                    top = 16.dp,
                                    bottom = 8.dp,
                                )
                            ) {
                                PelikulaText(
                                    modifier = Modifier
                                        .border(
                                            width = 1.dp,
                                            color = Color.DarkGray.copy(alpha = 0.8F),
                                            shape = RoundedCornerShape(size = 8.dp)
                                        )
                                        .padding(vertical = 4.dp, horizontal = 8.dp),
                                    text = it.name,
                                    fontWeight = FontWeight.Light,
                                    fontSize = 12.dp(),
                                )
                            }
                        }
                    }
                    PelikulaText(
                        modifier = Modifier.padding(8.dp),
                        text = "Overview",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.dp(),
                    )
                    PelikulaText(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = movieDetailUiState.movieDetail.overview,
                        fontWeight = FontWeight.Light,
                        fontSize = 16.dp(),
                        textAlign = TextAlign.Center
                    )
                }
            }
            is MovieDetailUiState.Error -> {
                PelikulaError(
                    modifier = Modifier.align(Alignment.Center),
                    message = movieDetailUiState.message
                )
            }
        }
    }
}

@Composable
fun Casts(modifier: Modifier = Modifier, movieCastUiState: MovieCastUiState) {
    Box(modifier = modifier.fillMaxSize()) {
        when (movieCastUiState) {
            is MovieCastUiState.Loading -> {
                PelikulaLoading(
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .padding(32.dp)
                )
            }
            is MovieCastUiState.Success -> {
                LazyRow(modifier = Modifier.padding(end = 8.dp)) {
                    items(items = movieCastUiState.movieCast.casts) {
                        Column(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .width(64.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .widthIn(64.dp)
                                    .height(100.dp),
                                elevation = CardDefaults.cardElevation(),
                            ) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://image.tmdb.org/t/p/original${it.profilePath}")
                                        .crossfade(enable = true)
                                        .build(),
                                    contentDescription = it.character,
                                    contentScale = ContentScale.FillHeight,
                                    modifier = Modifier
                                        .align(alignment = Alignment.CenterHorizontally),
                                )
                            }
                            PelikulaText(
                                modifier = Modifier
                                    .widthIn(64.dp),
                                text = it.name.replace(" ", "\n"),
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.dp(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
            is MovieCastUiState.Error -> {
                PelikulaError(
                    modifier = Modifier.align(Alignment.Center),
                    message = movieCastUiState.message
                )
            }
        }
    }
}

@Composable
fun Images(modifier: Modifier = Modifier, movieImagesUiState: MovieImagesUiState) {
    Box(modifier = modifier.fillMaxSize()) {
        when (movieImagesUiState) {
            is MovieImagesUiState.Loading -> {
                PelikulaLoading(
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .padding(32.dp)
                )
            }
            is MovieImagesUiState.Success -> {
                LazyRow(modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)) {
                    items(items = movieImagesUiState.movieImages.backdrops) {
                        Card(
                            modifier = Modifier
                                .widthIn(128.dp)
                                .height(100.dp)
                                .padding(start = 8.dp),
                            elevation = CardDefaults.cardElevation(),
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data("https://image.tmdb.org/t/p/original${it.filePath}")
                                    .crossfade(enable = true)
                                    .build(),
                                contentDescription = it.filePath,
                                contentScale = ContentScale.FillHeight,
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally),
                            )
                        }
                    }
                }
            }
            is MovieImagesUiState.Error -> {
                PelikulaError(
                    modifier = Modifier.align(Alignment.Center),
                    message = movieImagesUiState.message
                )
            }
        }
    }
}

@Composable
fun Recommendations(
    modifier: Modifier = Modifier,
    movieRecommendationsUiState: MovieRecommendationsUiState
) {
    Box(modifier = modifier.fillMaxSize()) {
        when (movieRecommendationsUiState) {
            is MovieRecommendationsUiState.Loading -> {
                PelikulaLoading(
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .padding(32.dp)
                )
            }
            is MovieRecommendationsUiState.Success -> {
                LazyRow(modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)) {
                    items(items = movieRecommendationsUiState.movieImages) {
                        Column {
                            Card(
                                modifier = Modifier
                                    .widthIn(80.dp)
                                    .height(100.dp)
                                    .padding(start = 8.dp),
                                elevation = CardDefaults.cardElevation(),
                            ) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://image.tmdb.org/t/p/original${it.posterPath}")
                                        .crossfade(enable = true)
                                        .build(),
                                    contentDescription = it.originalTitle,
                                    contentScale = ContentScale.FillHeight,
                                    modifier = Modifier
                                        .align(alignment = Alignment.CenterHorizontally),
                                )
                            }
                            PelikulaText(
                                modifier = Modifier
                                    .widthIn(80.dp),
                                text = it.originalTitle.replace(" ", "\n"),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.dp(),
                            )
                        }
                    }
                }
            }
            is MovieRecommendationsUiState.Error -> {
                PelikulaError(
                    modifier = Modifier.align(Alignment.Center),
                    message = movieRecommendationsUiState.message
                )
            }
        }
    }
}