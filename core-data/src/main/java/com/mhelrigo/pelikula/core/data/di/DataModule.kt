package com.mhelrigo.pelikula.core.data.di

import com.mhelrigo.pelikula.core.data.PelikulaRepository
import com.mhelrigo.pelikula.core.data.PelikulaRepositoryImpl
import com.mhelrigo.pelikula.core.network.PelikulaNetworkDataSource
import com.mhelrigo.pelikula.core.network.PelikulaNetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun bindPelikulaNetworkDataSource(pelikulaNetworkDataSourceImpl: PelikulaNetworkDataSourceImpl)
            : PelikulaNetworkDataSource

    @Binds
    @Singleton
    fun bindPelikulaRepository(pelikulaRepositoryImpl: PelikulaRepositoryImpl)
            : PelikulaRepository
}