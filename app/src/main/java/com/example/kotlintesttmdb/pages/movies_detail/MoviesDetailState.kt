package com.example.kotlintesttmdb.pages.movies_detail

import com.example.kotlintesttmdb.models.MoviesDetail

data class MoviesDetailState(
    val isLoading: Boolean = false,
    val data: MoviesDetail? = null,
    val error: String = ""
)