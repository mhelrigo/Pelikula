package com.mhelrigo.pelikula.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhelrigo.pelikula.core.commons.asResult
import com.mhelrigo.pelikula.core.data.PelikulaRepository
import com.mhelrigo.pelikula.core.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import com.mhelrigo.pelikula.core.commons.Result

@HiltViewModel
class HomeViewModel @Inject constructor(private val pelikulaRepository: PelikulaRepository) :
    ViewModel() {

    private val topRatedMovies: Flow<Result<List<Movie>>> =
        pelikulaRepository.getTopRatedMovies(page = 1).asResult()

    val topRatedMoviesState: StateFlow<MoviesUiState> = topRatedMovies
        .transform()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MoviesUiState.Loading
        )

    private val popularMovies: Flow<Result<List<Movie>>> =
        pelikulaRepository.getPopularMovies(page = 1).asResult()

    val popularMoviesState: StateFlow<MoviesUiState> = popularMovies
        .transform()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MoviesUiState.Loading
        )

    private val nowPlayingMovies: Flow<Result<List<Movie>>> =
        pelikulaRepository.getNowPlayingMovies(page = 1).asResult()

    val nowPlayingMoviesState: StateFlow<MoviesUiState> = nowPlayingMovies
        .transform()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MoviesUiState.Loading
        )
}

sealed class MoviesUiState {
    class Success(var movies: List<Movie>) : MoviesUiState()
    object Loading : MoviesUiState()
    class Error(message: String) : MoviesUiState()
}

fun Flow<Result<List<Movie>>>.transform(): Flow<MoviesUiState> = map { value ->
    when (value) {
        is Result.Success -> {
            MoviesUiState.Success(value.data)
        }
        is Result.Loading -> {
            MoviesUiState.Loading
        }
        is Result.Error -> {
            MoviesUiState.Error(value.exception?.message!!)
        }
    }
}