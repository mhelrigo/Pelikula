package com.mhelrigo.pelikula.core.data.fake

import com.mhelrigo.pelikula.core.data.PelikulaRepository
import com.mhelrigo.pelikula.core.data.model.asEntity
import com.mhelrigo.pelikula.core.model.Movie
import com.mhelrigo.pelikula.core.network.fake.FakeDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import java.io.IOException

class FakePelikulaRepository: PelikulaRepository {
    private var fakeStreamOfMovies: MutableSharedFlow<List<Movie>> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    /**
     * API for emitting fake data
     * */
    suspend fun sendFakeStreamOfData() {
        fakeStreamOfMovies.emit(FakeDataSource.topRatedMoviesApiResponse.results.asEntity())
    }

    override fun getTopRatedMovies(page: Int): Flow<List<Movie>> {
        return fakeStreamOfMovies
    }

    override fun getPopularMovies(page: Int): Flow<List<Movie>> {
        return fakeStreamOfMovies
    }

    override fun getNowPlayingMovies(page: Int): Flow<List<Movie>> {
        return fakeStreamOfMovies
    }
}