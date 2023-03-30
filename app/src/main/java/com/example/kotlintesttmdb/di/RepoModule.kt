package com.example.kotlintesttmdb.di

import com.example.kotlintesttmdb.network.repo.*
import com.example.kotlintesttmdb.network.usecases.GenresUseCase
import com.example.kotlintesttmdb.network.usecases.MoviesDetailUseCase
import com.example.kotlintesttmdb.network.usecases.MoviesGenreUseCase
import com.example.kotlintesttmdb.network.usecases.MoviesReviewsUseCase
import org.koin.dsl.module

val repoModule = module {
    single { GenresUseCase(get()) }
    single<GenresRepo> { GenreRepoImpl(get()) }
    single { MoviesGenreUseCase(get()) }
    single<MoviesGenreRepo> { MoviesGenreRepoImpl(get()) }
    single { MoviesDetailUseCase(get()) }
    single<MoviesDetailRepo> { MoviesDetailRepoImpl(get()) }
    single { MoviesReviewsUseCase(get()) }
    single<MoviesReviewsRepo> { MoviesReviewsRepoImpl(get()) }
}