package com.example.kotlintesttmdb.pages.movies_videos

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kotlintesttmdb.helper.Constants
import com.example.kotlintesttmdb.pages.movies_reviews.MoviesReviewsViewModel
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterialApi
@Composable
fun MoviesVideos(
    viewModel: MoviesVideosViewModel = getViewModel(),
    movieId: Int,
) {
    val reviewsState = viewModel.state.value
    val reviewsList = reviewsState.data?.results
    val uriHandler = LocalUriHandler.current

    LaunchedEffect(key1 = movieId) {
        viewModel.getMoviesVideos(movieId)
    }

    Column() {
        if (reviewsList != null) {
            LazyRow(contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)) {
                items(reviewsList) { item ->
                    if (item.site.lowercase().equals("youtube")) {
                        Card(
                            modifier = Modifier
                                .width(250.dp)
                                .height(100.dp)
                                .clickable { uriHandler.openUri(Constants.YOUTUBE_URL + item.key) }
                                .padding(8.dp),
                            backgroundColor = Color.DarkGray
                        ) {
                            Box() {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(Constants.YOUTUBE_THUMBNAIL + item.key + Constants.YOUTUBE_THUMBNAIL_RES)
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = "Trailer Image",
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop,
                                )
                            }
                        }
                    }
                }
            }
        } else {

        }
    }
}