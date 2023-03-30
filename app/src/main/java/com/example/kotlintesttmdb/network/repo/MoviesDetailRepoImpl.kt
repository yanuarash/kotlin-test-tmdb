package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.MoviesDetail
import com.example.kotlintesttmdb.models.MoviesGenre
import com.example.kotlintesttmdb.network.ApiRequest
import com.example.kotlintesttmdb.network.ApiService
import com.example.kotlintesttmdb.network.toDomain

class MoviesDetailRepoImpl constructor(private val apiService: ApiService): MoviesDetailRepo, ApiRequest(){

    override suspend fun getMoviesDetail(movieId: Int): MoviesDetail {
        val res = apiRequest { apiService.getMoviesDetail(movieId) }
        return res.toDomain()
    }
}