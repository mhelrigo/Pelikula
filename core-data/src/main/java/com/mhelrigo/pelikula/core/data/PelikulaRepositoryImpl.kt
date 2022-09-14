package com.mhelrigo.pelikula.core.data

import com.mhelrigo.pelikula.core.data.model.asEntity
import com.mhelrigo.pelikula.core.model.Movie
import com.mhelrigo.pelikula.core.network.PelikulaNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PelikulaRepositoryImpl @Inject constructor(private val pelikulaNetworkDataSource: PelikulaNetworkDataSource) :
    PelikulaRepository {

    override fun getTopRatedMovies(page: Int): Flow<List<Movie>> {
        return flow {
            emit(pelikulaNetworkDataSource.getTopRated(page = page).results.asEntity())
        }
    }

    override fun getPopularMovies(page: Int): Flow<List<Movie>> {
        return flow {
            emit(pelikulaNetworkDataSource.getPopular(page = page).results.asEntity())
        }
    }

    override fun getNowPlayingMovies(page: Int): Flow<List<Movie>> {
        return flow {
            emit(pelikulaNetworkDataSource.getNowPlayingMovies(page = page).results.asEntity())
        }
    }
}