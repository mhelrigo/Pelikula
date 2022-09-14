package com.mhelrigo.pelikula.core.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mhelrigo.pelikula.core.model.Movie

@Composable
fun MovieScreen(modifier: Modifier, movie: Movie) {
    Card(
        modifier = modifier
            .widthIn(64.dp),
        elevation = CardDefaults.cardElevation(),
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

@Preview(showBackground = true)
@Composable
fun MovieScreenPreview() {
    MovieScreen(
        modifier = Modifier,
        Movie(
            id = 278,
            voteCount = 22137,
            popularity = 118.72F,
            voteAverage = 8.7F,
            genreIds = listOf(18, 80),
            backDropPath = "/kXfqcdQKsToO0OUXHcrrNCHDBzO.jpg",
            originalLanguage = "en",
            originalTitle = "The Shawshank Redemption",
            overview = "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
            posterPath = "/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg",
            releaseDate = "1994-09-23",
            title = "The Shawshank Redemption",
            adult = false,
            video = false
        )
    )
}