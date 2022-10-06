package com.mhelrigo.pelikula.core.data.fake

import androidx.paging.PagingSource
import com.mhelrigo.pelikula.core.data.PelikulaRepository
import com.mhelrigo.pelikula.core.data.model.asEntity
import com.mhelrigo.pelikula.core.model.*
import com.mhelrigo.pelikula.core.network.fake.FakeDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import java.io.IOException

class FakePelikulaRepository : PelikulaRepository {
    private var fakeStreamOfMovies: MutableSharedFlow<MovieList> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    private var fakeStreamOfMovieDetail: MutableSharedFlow<MovieDetail> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.SUSPEND)

    private var fakeStreamOfMovieCredits: MutableSharedFlow<Credits> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.SUSPEND)

    private var fakeStreamOfMovieImages: MutableSharedFlow<MovieImages> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.SUSPEND)

    /**
     * API for emitting fake data
     * */
    suspend fun sendFakeStreamOfData() {
        fakeStreamOfMovies.emit(FakeDataSource.topRatedMoviesApiResponse.asEntity())
    }

    override fun getTopRatedMovies(page: Int): Flow<MovieList> {
        return fakeStreamOfMovies
    }

    override fun getPopularMovies(page: Int): Flow<MovieList> {
        return fakeStreamOfMovies
    }

    override fun getNowPlayingMovies(page: Int): Flow<MovieList> {
        return fakeStreamOfMovies
    }

    override fun getMovieDetail(movieId: Int): Flow<MovieDetail> {
        return fakeStreamOfMovieDetail
    }

    override fun getMovieCredits(movieId: Int): Flow<Credits> {
        return fakeStreamOfMovieCredits
    }

    override fun getMovieImages(movieId: Int): Flow<MovieImages> {
        return fakeStreamOfMovieImages
    }

    override fun getMovieRecommendations(movieId: Int): Flow<MovieList> {
        return fakeStreamOfMovies
    }

    override fun getExpandedMovieList(movieListType: MovieListType): PagingSource<Int, Movie> {
        TODO("Not yet implemented")
    }
}