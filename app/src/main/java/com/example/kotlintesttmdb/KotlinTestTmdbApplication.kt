package com.example.kotlintesttmdb

import android.app.Application
import com.example.kotlintesttmdb.di.networkModule
import com.example.kotlintesttmdb.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KotlinTestTmdbApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(networkModule, viewModelModule);

        startKoin{
            androidLogger(level = Level.NONE)
            androidContext(this@KotlinTestTmdbApplication)
            modules(modules)
        }
    }
}