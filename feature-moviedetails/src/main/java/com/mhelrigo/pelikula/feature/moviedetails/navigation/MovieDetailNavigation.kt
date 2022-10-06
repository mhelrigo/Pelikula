package com.mhelrigo.pelikula.feature.moviedetails.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mhelrigo.pelikula.core.commons.navigation.PelikulaDestination
import com.mhelrigo.pelikula.feature.moviedetails.MovieDetailRoute

object MovieDetailDestination : PelikulaDestination {
    override val route: String
        get() = "movieDetailScreen"

    const val movieIdArg = "movieIdArg"
}

fun NavGraphBuilder.movieDetailGraph(onBackPressed: () -> Unit) {
    composable(route = "${MovieDetailDestination.route}/{${MovieDetailDestination.movieIdArg}}",
        arguments = listOf(
            navArgument(MovieDetailDestination.movieIdArg) {
                type = NavType.IntType
            }
        )) {
        MovieDetailRoute(modifier = Modifier, onBackPressed = onBackPressed)
    }
}