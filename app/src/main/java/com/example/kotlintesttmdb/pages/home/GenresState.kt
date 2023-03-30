package com.example.kotlintesttmdb.pages.home

import com.example.kotlintesttmdb.models.Genres

data class GenresState(
    val isLoading: Boolean = false,
    val data: Genres? = null,
    val error: String =""
)