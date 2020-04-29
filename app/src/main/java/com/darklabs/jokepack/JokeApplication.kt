package com.darklabs.jokepack

import android.app.Application
import com.darklabs.jokepack.di.appModule
import com.darklabs.jokepack.di.networkModule
import com.darklabs.jokepack.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class JokeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@JokeApplication)
            androidLogger(Level.INFO)
            modules(listOf(viewModelModule, networkModule, appModule))
        }
    }
}