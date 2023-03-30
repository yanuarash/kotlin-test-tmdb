package com.example.kotlintesttmdb.models

import com.google.gson.annotations.SerializedName

data class MoviesDetailDto(
    @SerializedName("backdrop_path")
    val backdrop_path: String,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("vote_average")
    val vote_average: Number,
    @SerializedName("vote_count")
    val vote_count: Int,
    @SerializedName("genres")
    val genres: List<Genres>
)