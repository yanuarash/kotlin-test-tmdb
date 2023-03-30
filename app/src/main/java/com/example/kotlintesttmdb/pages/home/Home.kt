package com.example.kotlintesttmdb.pages.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterialApi
@Composable
fun Home(viewModel: HomeViewModel = getViewModel()){
    val genresState = viewModel.state.value
    val genreList = genresState.data?.genres

    Scaffold() { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            if (genreList != null) {
                LazyColumn(contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp)){
                    items(genreList){item ->
                        Card(modifier = Modifier.fillMaxWidth()
                            .padding(8.dp)
                            .clickable {  }) {
                            Text(text = item.name)
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