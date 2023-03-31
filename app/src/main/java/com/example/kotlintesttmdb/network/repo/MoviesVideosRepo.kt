package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.MoviesReviews
import com.example.kotlintesttmdb.models.MoviesVideos

interface MoviesVideosRepo{
    suspend fun getMoviesVideos(movieId: Int): MoviesVideos
}