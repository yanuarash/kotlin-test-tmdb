package com.example.kotlintesttmdb.pages.movies_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterialApi
@Composable
fun MoviesDetail(
    viewModel: MoviesDetailViewModel = getViewModel(),
    movieId: Int,
    navHostController: NavHostController
) {
    val moviesState = viewModel.state.value
    val moviesDetail = moviesState.data

    LaunchedEffect(key1 = movieId) {
        viewModel.getMoviesDetail(movieId)
    }

    Scaffold() { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            if (moviesDetail != null) {
                Text("${moviesDetail.title} ${moviesDetail.release_date}")
                Button(onClick = {
                    navHostController.navigate("moviesReviews/${moviesDetail.id}")
                }) {
                    Text(text = "User reviews")
                }
            } else {
                Snackbar() {
                    Text(text = "Error Fetching Data")
                }
            }
        }
    }
}