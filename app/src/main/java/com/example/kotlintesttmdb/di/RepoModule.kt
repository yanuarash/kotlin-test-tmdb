package com.example.kotlintesttmdb.di

import com.example.kotlintesttmdb.network.repo.GenreRepoImpl
import com.example.kotlintesttmdb.network.repo.GenresRepo
import com.example.kotlintesttmdb.network.repo.MoviesGenreRepo
import com.example.kotlintesttmdb.network.repo.MoviesGenreRepoImpl
import com.example.kotlintesttmdb.network.usecases.GenresUseCase
import com.example.kotlintesttmdb.network.usecases.MoviesGenreUseCase
import org.koin.dsl.module

val repoModule = module {
    single{ GenresUseCase(get()) }
    single<GenresRepo>{ GenreRepoImpl(get()) }
    single{ MoviesGenreUseCase(get()) }
    single<MoviesGenreRepo>{ MoviesGenreRepoImpl(get()) }
}