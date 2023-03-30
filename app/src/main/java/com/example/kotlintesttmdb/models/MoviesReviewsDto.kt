package com.example.kotlintesttmdb.models

import com.google.gson.annotations.SerializedName

data class MoviesReviewsDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val total_results: Int,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("results")
    val results: List<MoviesReviewsItem>
)