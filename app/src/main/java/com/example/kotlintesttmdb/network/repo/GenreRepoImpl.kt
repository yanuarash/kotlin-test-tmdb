package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.Genres
import com.example.kotlintesttmdb.network.ApiRequest
import com.example.kotlintesttmdb.network.ApiService
import com.example.kotlintesttmdb.network.toDomain

class GenreRepoImpl constructor(private val apiService: ApiService): GenresRepo, ApiRequest(){

    override suspend fun getGenres(language: String): Genres {
        val res = apiRequest { apiService.getGenres(language = "en-US") }
        return res.toDomain()
    }
}