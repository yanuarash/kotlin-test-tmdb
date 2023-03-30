package com.example.kotlintesttmdb.models

import com.google.gson.annotations.SerializedName

data class GenresDto (
    @SerializedName("genres")
    val genres: List<GenresItem>,
)