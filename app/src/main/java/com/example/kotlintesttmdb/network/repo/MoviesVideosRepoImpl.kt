package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.MoviesReviews
import com.example.kotlintesttmdb.models.MoviesVideos
import com.example.kotlintesttmdb.network.ApiRequest
import com.example.kotlintesttmdb.network.ApiService
import com.example.kotlintesttmdb.network.toDomain

class MoviesVideosRepoImpl constructor(private val apiService: ApiService): MoviesVideosRepo, ApiRequest(){

    override suspend fun getMoviesVideos(movieId: Int): MoviesVideos {
        val res = apiRequest { apiService.getMoviesVideos(movieId) }
        return res.toDomain()
    }
}