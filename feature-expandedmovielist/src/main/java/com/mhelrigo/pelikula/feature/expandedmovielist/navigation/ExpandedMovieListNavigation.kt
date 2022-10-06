package com.mhelrigo.pelikula.feature.expandedmovielist.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mhelrigo.pelikula.core.commons.navigation.PelikulaDestination
import com.mhelrigo.pelikula.core.model.Movie
import com.mhelrigo.pelikula.feature.expandedmovielist.ExpandedMovieListRoute

object ExpandedMovieListNavigation : PelikulaDestination {
    override val route: String
        get() = "expandedMovieList"

    const val expandedMovieListType = "expandedMovieListType"
}

fun NavGraphBuilder.expandedMovieListGraph(
    onBackPressed: () -> Unit,
    navigateToMovieDetail: (movieId: Int) -> Unit,
) {
    composable(route = "${ExpandedMovieListNavigation.route}/{${ExpandedMovieListNavigation.expandedMovieListType}}",
        arguments = listOf(
            navArgument(name = ExpandedMovieListNavigation.expandedMovieListType) {
                type = NavType.IntType
            }
        )) {
        ExpandedMovieListRoute(
            onBackPressed = onBackPressed,
            expandMovie = { navigateToMovieDetail(it.id) })
    }
}