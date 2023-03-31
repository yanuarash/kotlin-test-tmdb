package com.example.kotlintesttmdb.di

import com.example.kotlintesttmdb.network.repo.*
import com.example.kotlintesttmdb.network.usecases.*
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
    single { MoviesVideosUseCase(get()) }
    single<MoviesVideosRepo> { MoviesVideosRepoImpl(get()) }
}