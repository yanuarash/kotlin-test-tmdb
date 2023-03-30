package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.MoviesGenre
import com.example.kotlintesttmdb.network.ApiRequest
import com.example.kotlintesttmdb.network.ApiService
import com.example.kotlintesttmdb.network.toDomain

class MoviesGenreRepoImpl constructor(private val apiService: ApiService): MoviesGenreRepo, ApiRequest(){

    override suspend fun getMoviesGenre(page: Int, withGenres: String): MoviesGenre {
        val res = apiRequest { apiService.getMoviesGenre(page = page, withGenres = withGenres, language = "en-US", sortBy = "popularity.desc") }
        return res.toDomain()
    }
}