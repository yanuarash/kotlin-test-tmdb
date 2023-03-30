package com.example.kotlintesttmdb.network

import com.example.kotlintesttmdb.models.GenresDto
import com.example.kotlintesttmdb.helper.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String,
    ): Response<GenresDto>
}