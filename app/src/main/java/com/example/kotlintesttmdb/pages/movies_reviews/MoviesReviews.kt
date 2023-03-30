package com.example.kotlintesttmdb.pages.movies_reviews

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterialApi
@Composable
fun MoviesReviews(
    viewModel: MoviesReviewsViewModel = getViewModel(),
    movieId: Int,
) {
    val movieGenreState = viewModel.state.value
    val movieGenreList = movieGenreState.data?.results
    val page = 1

    LaunchedEffect(key1 = movieId) {
        viewModel.getMoviesReviews(movieId, page)
    }

    Scaffold() { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            if (movieGenreList != null) {
                LazyColumn(contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp)) {
                    items(movieGenreList) { item ->
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                            }) {
                            Text(text = item.author)
                            Text(text = item.content)
                        }
                    }
                }
            } else {
                Snackbar() {
                    Text(text = "Error Fetching Data")
                }
            }
        }
    }
}