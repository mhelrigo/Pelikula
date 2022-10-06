package com.mhelrigo.pelikula.core.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mhelrigo.pelikula.core.data.model.asEntity
import com.mhelrigo.pelikula.core.model.Movie
import com.mhelrigo.pelikula.core.model.MovieListType
import com.mhelrigo.pelikula.core.network.PelikulaNetworkDataSource
import javax.inject.Inject
import javax.inject.Singleton

const val STARTING_KEY = 1
const val MAX_KEY = 20

@Singleton
class MovieListPagingSource @Inject constructor(val pelikulaNetworkDataSource: PelikulaNetworkDataSource) :
    PagingSource<Int, Movie>() {

    private lateinit var movieListType: MovieListType
    fun changeMovieListType(movieListType: MovieListType) {
        this.movieListType = movieListType
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        val nextPage = params.key ?: STARTING_KEY

        try {
            val result = when (movieListType) {
                MovieListType.POPULAR -> {
                    pelikulaNetworkDataSource.getPopular(page = nextPage)
                }
                MovieListType.NOW_PLAYING -> {
                    pelikulaNetworkDataSource.getNowPlayingMovies(page = nextPage)
                }
                MovieListType.TOP_RATED -> {
                    pelikulaNetworkDataSource.getTopRated(page = nextPage)
                }
            }

            return LoadResult.Page(
                data = result.results.asEntity(),
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (MAX_KEY >= nextPage) result.page + 1 else null
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}