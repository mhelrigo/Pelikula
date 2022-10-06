package com.mhelrigo.pelikula.core.data.model

import com.mhelrigo.pelikula.core.model.Cast
import com.mhelrigo.pelikula.core.model.Credits
import com.mhelrigo.pelikula.core.network.model.CastModel
import com.mhelrigo.pelikula.core.network.model.CreditsApiResponse

fun CreditsApiResponse.asEntity() = Credits(movieId = movieId, casts = casts.asEntity())

fun CastModel.asEntity() = Cast(
    id = id,
    gender = gender,
    castId = castId,
    order = order,
    popularity = popularity,
    knownForDepartment = knownForDepartment,
    name = name,
    originalName = originalName,
    profilePath = profilePath,
    character = character,
    creditId = creditId
)

fun List<CastModel>.asEntity() = this.map {
    it.asEntity()
}