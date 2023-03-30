package com.example.kotlintesttmdb.di

import com.example.kotlintesttmdb.pages.home.HomeViewModel
import com.example.kotlintesttmdb.pages.movies_detail.MoviesDetailViewModel
import com.example.kotlintesttmdb.pages.movies_genre.MoviesGenreViewModel
import com.example.kotlintesttmdb.pages.movies_reviews.MoviesReviewsViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single{HomeViewModel(get())}
    single{MoviesGenreViewModel(get())}
    single{MoviesDetailViewModel(get())}
    single{MoviesReviewsViewModel(get())}
}