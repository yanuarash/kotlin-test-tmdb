package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.MoviesGenre
import com.example.kotlintesttmdb.models.MoviesReviews
import com.example.kotlintesttmdb.network.ApiRequest
import com.example.kotlintesttmdb.network.ApiService
import com.example.kotlintesttmdb.network.toDomain

class MoviesReviewsRepoImpl constructor(private val apiService: ApiService): MoviesReviewsRepo, ApiRequest(){

    override suspend fun getMoviesReviews(movieId: Int): MoviesReviews {
        val res = apiRequest { apiService.getMoviesReviews(movieId) }
        return res.toDomain()
    }
}