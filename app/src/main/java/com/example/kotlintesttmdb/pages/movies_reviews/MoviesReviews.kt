package com.example.kotlintesttmdb.pages.movies_reviews

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterialApi
@Composable
fun MoviesReviews(
    viewModel: MoviesReviewsViewModel = getViewModel(),
    movieId: Int,
) {
    val reviewsState = viewModel.state.value
    val reviewsList = reviewsState.data?.results
    val page = 1

    LaunchedEffect(key1 = movieId) {
        viewModel.getMoviesReviews(movieId, page)
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "User Reviews") })
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            if (reviewsList != null) {
                LazyColumn(contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp)) {
                    items(reviewsList) { item ->
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                            backgroundColor = Color.DarkGray
                        ) {
                            Column(modifier = Modifier
                                .padding(all = 8.dp)
                                ) {
                                Text(text = "@${item.author}", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = item.content)
                            }
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