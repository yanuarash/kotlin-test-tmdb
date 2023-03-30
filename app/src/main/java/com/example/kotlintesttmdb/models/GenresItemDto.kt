package com.example.kotlintesttmdb.models

import com.google.gson.annotations.SerializedName

data class GenresItemDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)