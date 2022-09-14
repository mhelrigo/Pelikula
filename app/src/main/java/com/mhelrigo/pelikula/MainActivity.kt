package com.mhelrigo.pelikula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.mhelrigo.pelikula.core.designsystem.theme.PelikulaTheme
import com.mhelrigo.pelikula.feature.home.HomeScreen
import com.mhelrigo.pelikula.feature.home.HomeViewModel
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
                    HomeScreen(
                        modifier = Modifier,
                        topRatedMoviesUiState = homeViewModel.topRatedMoviesState.collectAsState().value,
                        popularMoviesUiState = homeViewModel.popularMoviesState.collectAsState().value,
                        nowPlayingMoviesUiState = homeViewModel.nowPlayingMoviesState.collectAsState().value
                    )
                }
            }
        }
    }
}