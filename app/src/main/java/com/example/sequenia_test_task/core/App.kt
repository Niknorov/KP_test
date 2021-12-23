package com.example.sequenia_test_task.core

import android.app.Application
import com.example.sequenia_test_task.core.di.networkModule
import com.example.sequenia_test_task.feature.films.di.filmsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                filmsModule,
                )
        }
    }
}