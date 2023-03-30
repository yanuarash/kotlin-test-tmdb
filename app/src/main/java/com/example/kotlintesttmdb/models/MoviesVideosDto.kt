package com.example.kotlintesttmdb.models

import com.google.gson.annotations.SerializedName

data class MoviesVideosDto (
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<MoviesVideosItem>
)