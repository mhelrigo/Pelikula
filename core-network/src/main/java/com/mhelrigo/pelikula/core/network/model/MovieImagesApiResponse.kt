package com.mhelrigo.pelikula.core.network.model

import com.google.gson.annotations.SerializedName

data class MovieImagesApiResponse(
    val id: Int,
    @SerializedName("backdrops") val backdropModels: List<BackdropModel>,
    @SerializedName("logos") val logoModels: List<LogoModel>,
    @SerializedName("posters") val posterModels: List<PosterModel>
) {
}

data class BackdropModel(
    val height: Int,
    val width: Int,
    @SerializedName("file_path") val filePath: String
)

data class LogoModel(
    val height: Int,
    val width: Int,
    @SerializedName("file_path") val filePath: String
)

data class PosterModel(
    val height: Int,
    val width: Int,
    @SerializedName("file_path") val filePath: String
)