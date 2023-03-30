package com.example.kotlintesttmdb.network

import com.example.kotlintesttmdb.models.*

internal fun GenresDto.toDomain(): Genres {
    return Genres(genres)
}

internal fun MoviesGenreDto.toDomain(): MoviesGenre {
    return MoviesGenre(page, total_results, total_pages, results)
}

internal fun MoviesDetailDto.toDomain(): MoviesDetail {
    return MoviesDetail(backdrop_path, budget, id, title, release_date, tagline, overview, vote_average, vote_count, genres)
}

internal fun MoviesReviewsDto.toDomain(): MoviesReviews {
    return MoviesReviews(id, page, total_pages, total_results, results)
}