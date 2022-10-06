package com.mhelrigo.pelikula.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mhelrigo.pelikula.core.commons.navigation.PelikulaDestination
import com.mhelrigo.pelikula.core.model.MovieListType
import com.mhelrigo.pelikula.feature.home.HomeRoute

object HomeNavigation : PelikulaDestination {
    override val route: String
        get() = "homeScreen"
}

fun NavGraphBuilder.homeGraph(
    navigateToMovieDetail: (movieId: Int) -> Unit,
    navigateToExpandedMovieList: (type: MovieListType) -> Unit
) {
    composable(route = HomeNavigation.route) {
        HomeRoute(
            expandMovie = { navigateToMovieDetail(it.id) },
            expandMovieList = {
                navigateToExpandedMovieList(it)
            }
        )
    }
}