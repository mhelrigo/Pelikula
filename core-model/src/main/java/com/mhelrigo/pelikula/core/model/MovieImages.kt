package com.mhelrigo.pelikula.core.model

data class MovieImages(
    val id: Int,
    val backdrops: List<Backdrop>,
    val logos: List<Logo>,
    val posters: List<Poster>
) {
}

data class Backdrop(val height: Int, val width: Int, val filePath: String)

data class Logo(val height: Int, val width: Int, val filePath: String)

data class Poster(val height: Int, val width: Int, val filePath: String)