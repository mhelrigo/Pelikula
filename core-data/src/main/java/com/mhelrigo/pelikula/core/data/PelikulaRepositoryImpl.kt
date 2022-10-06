package com.mhelrigo.pelikula.core.data

import androidx.paging.PagingSource
import com.mhelrigo.pelikula.core.data.model.asEntity
import com.mhelrigo.pelikula.core.model.*
import com.mhelrigo.pelikula.core.network.PelikulaNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class PelikulaRepositoryImpl @Inject constructor(
    private val pelikulaNetworkDataSource: PelikulaNetworkDataSource,
    private val movieListPagingSource: MovieListPagingSource
) : PelikulaRepository {

    override fun getTopRatedMovies(page: Int): Flow<MovieList> {
        return flow {
            emit(pelikulaNetworkDataSource.getTopRated(page = page).asEntity())
        }
    }

    override fun getPopularMovies(page: Int): Flow<MovieList> {
        return flow {
            emit(pelikulaNetworkDataSource.getPopular(page = page).asEntity())
        }
    }

    override fun getNowPlayingMovies(page: Int): Flow<MovieList> {
        return flow {
            emit(pelikulaNetworkDataSource.getNowPlayingMovies(page = page).asEntity())
        }
    }

    override fun getMovieDetail(movieId: Int): Flow<MovieDetail> {
        return flow {
            emit(pelikulaNetworkDataSource.getMovieDetail(movieId = movieId).asEntity())
        }
    }

    override fun getMovieCredits(movieId: Int): Flow<Credits> {
        return flow {
            emit(pelikulaNetworkDataSource.getMovieCredits(movieId = movieId).asEntity())
        }
    }

    override fun getMovieImages(movieId: Int): Flow<MovieImages> {
        return flow {
            emit(pelikulaNetworkDataSource.getMovieImages(movieId = movieId).asEntity())
        }
    }

    override fun getMovieRecommendations(movieId: Int): Flow<MovieList> {
        return flow {
            emit(pelikulaNetworkDataSource.getMovieRecommendations(movieId = movieId).asEntity())
        }
    }

    override fun getExpandedMovieList(movieListType: MovieListType):
            PagingSource<Int, Movie> {
        movieListPagingSource.changeMovieListType(movieListType)
        return movieListPagingSource
    }
}