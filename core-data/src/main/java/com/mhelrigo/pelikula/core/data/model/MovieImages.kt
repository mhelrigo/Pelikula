package com.mhelrigo.pelikula.core.data.model

import com.mhelrigo.pelikula.core.model.Backdrop
import com.mhelrigo.pelikula.core.model.Logo
import com.mhelrigo.pelikula.core.model.MovieImages
import com.mhelrigo.pelikula.core.model.Poster
import com.mhelrigo.pelikula.core.network.model.BackdropModel
import com.mhelrigo.pelikula.core.network.model.LogoModel
import com.mhelrigo.pelikula.core.network.model.MovieImagesApiResponse
import com.mhelrigo.pelikula.core.network.model.PosterModel

fun MovieImagesApiResponse.asEntity() = MovieImages(
    id = id,
    backdrops = backdropModels.asEntity(),
    logos = logoModels.asEntityLogoModel(),
    posters = posterModels.asEntityPosterModel()
)

fun BackdropModel.asEntity() = Backdrop(height = height, width = width, filePath = filePath)

fun List<BackdropModel>.asEntity() = this.map {
    it.asEntity()
}

fun LogoModel.asEntity() = Logo(height = height, width = width, filePath = filePath)

fun List<LogoModel>.asEntityLogoModel() = this.map {
    it.asEntity()
}

fun PosterModel.asEntity() = Poster(height = height, width = width, filePath = filePath)

fun List<PosterModel>.asEntityPosterModel() = this.map {
    it.asEntity()
}