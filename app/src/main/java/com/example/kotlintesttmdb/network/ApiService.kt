package com.example.kotlintesttmdb.network

import com.example.kotlintesttmdb.models.GenresDto
import com.example.kotlintesttmdb.helper.Constants
import com.example.kotlintesttmdb.models.MoviesDetail
import com.example.kotlintesttmdb.models.MoviesDetailDto
import com.example.kotlintesttmdb.models.MoviesGenreDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String,
    ): Response<GenresDto>

    @GET("discover/movie")
    suspend fun getMoviesGenre(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String,
        @Query("page") page: Int,
        @Query("with_genres") withGenres: String,
    ): Response<MoviesGenreDto>

    @GET("movie/{movie_id}")
    suspend fun getMoviesDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
    ): Response<MoviesDetailDto>
}