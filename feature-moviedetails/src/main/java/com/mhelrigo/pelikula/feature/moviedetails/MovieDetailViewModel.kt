package com.mhelrigo.pelikula.feature.moviedetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhelrigo.pelikula.core.commons.Result
import com.mhelrigo.pelikula.core.commons.asResult
import com.mhelrigo.pelikula.core.data.PelikulaRepository
import com.mhelrigo.pelikula.core.model.*
import com.mhelrigo.pelikula.feature.moviedetails.navigation.MovieDetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: PelikulaRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var movieId: Int = checkNotNull(savedStateHandle[MovieDetailDestination.movieIdArg])

    private val movieDetail: Flow<Result<MovieDetail>> =
        repository.getMovieDetail(movieId).asResult()

    val movieDetailState: StateFlow<MovieDetailUiState> = movieDetail
        .map {
            when (it) {
                is Result.Loading -> {
                    MovieDetailUiState.Loading
                }
                is Result.Success -> {
                    MovieDetailUiState.Success(it.data)
                }
                is Result.Error -> {
                    MovieDetailUiState.Error("")
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = MovieDetailUiState.Loading
        )

    private val movieCast: Flow<Result<Credits>> = repository.getMovieCredits(movieId).asResult()

    val movieCastUiState: StateFlow<MovieCastUiState> = movieCast
        .map {
            when (it) {
                is Result.Loading -> {
                    MovieCastUiState.Loading
                }
                is Result.Success -> {
                    MovieCastUiState.Success(it.data)
                }
                is Result.Error -> {
                    MovieCastUiState.Error("")
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = MovieCastUiState.Loading
        )

    private val movieImages: Flow<Result<MovieImages>> =
        repository.getMovieImages(movieId = movieId).asResult()

    val movieImagesUiState: StateFlow<MovieImagesUiState> = movieImages
        .map {
            when (it) {
                is Result.Loading -> {
                    MovieImagesUiState.Loading
                }
                is Result.Success -> {
                    MovieImagesUiState.Success(it.data)
                }
                is Result.Error -> {
                    MovieImagesUiState.Error("")
                }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = MovieImagesUiState.Loading
        )

    private val movieRecommendations: Flow<Result<MovieList>> =
        repository.getMovieRecommendations(movieId).asResult()

    val movieRecommendationsUiState: StateFlow<MovieRecommendationsUiState> = movieRecommendations
        .map {
            when (it) {
                is Result.Loading -> {
                    MovieRecommendationsUiState.Loading
                }
                is Result.Success -> {
                    MovieRecommendationsUiState.Success(it.data.results)
                }
                is Result.Error -> {
                    MovieRecommendationsUiState.Error("")
                }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = MovieRecommendationsUiState.Loading
        )
}

sealed class MovieDetailUiState {
    class Success(val movieDetail: MovieDetail) : MovieDetailUiState()
    object Loading : MovieDetailUiState()
    class Error(val message: String) : MovieDetailUiState()
}

sealed class MovieCastUiState {
    class Success(val movieCast: Credits) : MovieCastUiState()
    object Loading : MovieCastUiState()
    class Error(val message: String) : MovieCastUiState()
}

sealed class MovieImagesUiState {
    class Success(val movieImages: MovieImages) : MovieImagesUiState()
    object Loading : MovieImagesUiState()
    class Error(val message: String) : MovieImagesUiState()
}

sealed class MovieRecommendationsUiState {
    class Success(val movieImages: List<Movie>) : MovieRecommendationsUiState()
    object Loading : MovieRecommendationsUiState()
    class Error(val message: String) : MovieRecommendationsUiState()
}