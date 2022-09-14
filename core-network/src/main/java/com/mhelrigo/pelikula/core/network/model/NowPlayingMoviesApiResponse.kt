package com.mhelrigo.pelikula.core.network.model

import com.google.gson.annotations.SerializedName

data class NowPlayingMoviesApiResponse (
    val page: Int,
    val results: List<MovieModel>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResult: Int
)