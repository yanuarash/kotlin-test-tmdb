package com.example.kotlintesttmdb.di

import com.example.kotlintesttmdb.pages.home.HomeViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single{HomeViewModel(get())}
}