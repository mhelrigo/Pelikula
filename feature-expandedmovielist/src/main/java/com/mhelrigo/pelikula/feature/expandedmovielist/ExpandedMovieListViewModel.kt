package com.mhelrigo.pelikula.feature.expandedmovielist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mhelrigo.pelikula.core.commons.asResult
import com.mhelrigo.pelikula.core.data.MovieListPagingSource
import com.mhelrigo.pelikula.core.data.PelikulaRepository
import com.mhelrigo.pelikula.core.model.Movie
import com.mhelrigo.pelikula.core.model.MovieList
import com.mhelrigo.pelikula.core.model.MovieListType
import com.mhelrigo.pelikula.feature.expandedmovielist.navigation.ExpandedMovieListNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ExpandedMovieListViewModel @Inject constructor(
    private val repository: PelikulaRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val expandedMovieListType =
        when (checkNotNull(savedStateHandle[ExpandedMovieListNavigation.expandedMovieListType])) {
            MovieListType.POPULAR.value -> {
                MovieListType.POPULAR
            }
            MovieListType.NOW_PLAYING.value -> {
                MovieListType.NOW_PLAYING
            }
            MovieListType.TOP_RATED.value -> {
                MovieListType.TOP_RATED
            }
            else -> {
                throw IllegalArgumentException()
            }
        }

    val expandedMovieListTypeName = when (expandedMovieListType) {
        MovieListType.POPULAR -> {
            "Popular Now"
        }
        MovieListType.NOW_PLAYING -> {
            "Being Watched"
        }
        MovieListType.TOP_RATED -> {
            "All Time Favorites"
        }
        else -> {
            throw IllegalArgumentException()
        }
    }

    val movieList: Flow<PagingData<Movie>> = Pager(PagingConfig(pageSize = 19)) {
        repository.getExpandedMovieList(expandedMovieListType)
    }.flow.cachedIn(viewModelScope)
}