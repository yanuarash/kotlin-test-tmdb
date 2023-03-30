package com.example.kotlintesttmdb.network

import com.example.kotlintesttmdb.models.GenresDto
import com.example.kotlintesttmdb.models.Genres

internal fun GenresDto.toDomain(): Genres{
    return Genres(genres)
}