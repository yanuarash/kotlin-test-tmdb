package com.example.kotlintesttmdb.pages.movies_genre

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kotlintesttmdb.helper.Constants
import com.example.kotlintesttmdb.pages.home.HomeViewModel
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterialApi
@Composable
fun MoviesGenre(
    viewModel: MoviesGenreViewModel = getViewModel(),
    withGenres: String,
    navHostController: NavHostController,
) {
    val movieGenreState = viewModel.state.value
    val movieGenreList = movieGenreState.data?.results
    val page = 1

    LaunchedEffect(key1 = withGenres) {
        viewModel.getMoviesGenre(page, withGenres)
    }

    Scaffold() { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            if (movieGenreList != null) {
                LazyColumn(contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp)) {
                    items(movieGenreList) { item ->
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(8.dp)
                            .clickable {
                                navHostController.navigate("moviesDetail/${item.id}")
                            }) {

                            Box() {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(Constants.IMAGE_W1280_URL + item.backdrop_path)
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = "Movie Image",
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop,
                                )
                                Column() {
                                    Modifier
                                        .fillMaxSize()
                                        .background(
                                            Brush.verticalGradient(
                                                listOf(
                                                    Color.Transparent,
                                                    Color.Black
                                                ),
                                                0f,
                                                500f
                                            )
                                        )
                                }
                                Text(
                                    text = item.title,
                                    modifier = Modifier
                                        .align(Alignment.BottomStart)
                                        .padding(all = 8.dp)
                                )
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

