package com.example.kotlintesttmdb.network

import com.example.kotlintesttmdb.models.GenresDto
import com.example.kotlintesttmdb.models.Genres
import com.example.kotlintesttmdb.models.MoviesGenre
import com.example.kotlintesttmdb.models.MoviesGenreDto

internal fun GenresDto.toDomain(): Genres {
    return Genres(genres)
}

internal fun MoviesGenreDto.toDomain(): MoviesGenre {
    return MoviesGenre(page, total_results, total_pages, results)
}