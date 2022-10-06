package com.mhelrigo.pelikula.core.model

data class Credits(val movieId: Int, val casts: List<Cast>) {
}

data class Cast(
    val id: Int,
    val gender: Int,
    val castId: Int,
    val order: Int,
    val popularity: Float,
    val knownForDepartment: String,
    val name: String,
    val originalName: String,
    val profilePath: String? = null,
    val character: String,
    val creditId: String
)