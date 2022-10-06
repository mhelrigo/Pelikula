package com.mhelrigo.pelikula.core.network.model

import com.google.gson.annotations.SerializedName

data class CreditsApiResponse(
    @SerializedName("id") val movieId: Int,
    @SerializedName("cast") val casts: List<CastModel>
) {
}

data class CastModel(
    val id: Int,
    val gender: Int,
    @SerializedName("cast_id")
    val castId: Int,
    val order: Int,
    val popularity: Float,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    val name: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("profile_path")
    val profilePath: String? = null,
    val character: String,
    @SerializedName("credit_id")
    val creditId: String
)