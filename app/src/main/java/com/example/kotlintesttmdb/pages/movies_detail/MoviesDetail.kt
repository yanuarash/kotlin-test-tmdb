package com.example.kotlintesttmdb.pages.movies_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kotlintesttmdb.helper.Constants
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
//                Text("${moviesDetail.title} ${moviesDetail.release_date}")
//                Button(onClick = {
//                    navHostController.navigate("moviesReviews/${moviesDetail.id}")
//                }){}
                Column(modifier = Modifier.weight(2f).fillMaxHeight()) {
                    Column() {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(Constants.IMAGE_W1280_URL + moviesDetail.backdrop_path)
                                .crossfade(true).build(),
                            contentDescription = "Movie Image",
                            modifier = Modifier
                                .height(300.dp)
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop,
                        )
                        Column(
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = moviesDetail.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            )
                            if (!moviesDetail.tagline.isEmpty()) {
                                Text(
                                    text = moviesDetail.tagline,
                                    color = Color.LightGray,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        Divider(
                            color = Color.DarkGray, modifier = Modifier
                                .fillMaxWidth()
                                .width(1.dp)
                        )
                        Column(modifier = Modifier.padding(all = 8.dp)) {
                            Text(text = "Overview", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                            Text(text = moviesDetail.overview)
                        }
                    }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 12.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "User Reviews - ${moviesDetail.vote_average}")
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