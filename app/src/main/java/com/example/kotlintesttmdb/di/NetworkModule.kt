package com.example.kotlintesttmdb.di

import com.example.kotlintesttmdb.helper.Constants
import com.example.kotlintesttmdb.network.ApiService
import com.example.kotlintesttmdb.network.repo.GenreRepoImpl
import com.example.kotlintesttmdb.network.repo.GenresRepo
import com.example.kotlintesttmdb.network.usecases.GenresUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module{
    single{
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkhttp())
            .build()
            .create(ApiService::class.java)
    }
    single{GenresUseCase(get())}
    single<GenresRepo>{ GenreRepoImpl(get())}
}

fun provideOkhttp(): OkHttpClient{
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

fun loggingInterceptor(): HttpLoggingInterceptor{
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}




