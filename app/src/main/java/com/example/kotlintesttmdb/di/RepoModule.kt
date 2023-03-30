package com.example.kotlintesttmdb.di

import com.example.kotlintesttmdb.network.repo.*
import com.example.kotlintesttmdb.network.usecases.GenresUseCase
import com.example.kotlintesttmdb.network.usecases.MoviesGenreUseCase
import org.koin.dsl.module

val repoModule = module {
    single{ GenresUseCase(get()) }
    single<GenresRepo>{ GenreRepoImpl(get()) }
    single{ MoviesGenreUseCase(get()) }
    single<MoviesGenreRepo>{ MoviesGenreRepoImpl(get()) }
    single{ MoviesGenreUseCase(get()) }
    single<MoviesDetailRepo>{ MoviesDetailRepoImpl(get()) }
}