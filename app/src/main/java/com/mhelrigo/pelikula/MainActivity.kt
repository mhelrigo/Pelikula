package com.mhelrigo.pelikula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mhelrigo.pelikula.core.designsystem.theme.PelikulaTheme
import com.mhelrigo.pelikula.feature.expandedmovielist.navigation.ExpandedMovieListNavigation
import com.mhelrigo.pelikula.feature.expandedmovielist.navigation.expandedMovieListGraph
import com.mhelrigo.pelikula.feature.home.HomeViewModel
import com.mhelrigo.pelikula.feature.home.navigation.HomeNavigation
import com.mhelrigo.pelikula.feature.home.navigation.homeGraph
import com.mhelrigo.pelikula.feature.moviedetails.navigation.MovieDetailDestination
import com.mhelrigo.pelikula.feature.moviedetails.navigation.movieDetailGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PelikulaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController = rememberNavController()
                    PelikulaNavHost(
                        modifier = Modifier,
                        navHostController = navHostController
                    )
                }
            }
        }
    }
}

@Composable
fun PelikulaNavHost(
    modifier: Modifier,
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeNavigation.route,
        modifier = modifier
    ) {
        homeGraph(navigateToMovieDetail = {
            navHostController.navigate("${MovieDetailDestination.route}/$it")
        }, navigateToExpandedMovieList = {
            navHostController.navigate("${ExpandedMovieListNavigation.route}/${it.value}")
        })
        movieDetailGraph(onBackPressed = { navHostController.popBackStack() })
        expandedMovieListGraph(onBackPressed = { navHostController.popBackStack() }, navigateToMovieDetail = {
            navHostController.navigate("${MovieDetailDestination.route}/$it")
        })
    }
}