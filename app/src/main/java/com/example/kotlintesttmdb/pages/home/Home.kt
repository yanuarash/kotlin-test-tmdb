package com.example.kotlintesttmdb.pages.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterialApi
@Composable
fun Home(viewModel: HomeViewModel = getViewModel(), navHostController: NavHostController) {
    val genresState = viewModel.state.value
    val genreList = genresState.data?.genres

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Genre") })
    }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            if (genreList != null) {
                Column() {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2)
                    ) {
                        items(genreList) { item ->
                            Card(backgroundColor = Color.DarkGray, modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .height(90.dp)
                                .clickable {
                                    navHostController.navigate("moviesGenre/${item.id}")
                                }) {
                                Text(
                                    text = item.name,
                                    fontSize = 20.sp,
                                    modifier = Modifier.padding(all = 8.dp)
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