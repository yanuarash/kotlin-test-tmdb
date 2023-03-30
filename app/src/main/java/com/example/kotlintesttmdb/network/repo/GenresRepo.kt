package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.Genres

interface GenresRepo{
    suspend fun getGenres(language:String):Genres
}