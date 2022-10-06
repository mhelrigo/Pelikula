package com.mhelrigo.pelikula.core.model

data class MovieList(val page: Int,
                     val results: List<Movie>,
                     val totalPages: Int,
                     val totalResult: Int)