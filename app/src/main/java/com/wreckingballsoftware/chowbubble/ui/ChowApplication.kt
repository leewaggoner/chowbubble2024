package com.wreckingballsoftware.chowbubble.ui

import android.app.Application
import com.wreckingballsoftware.chowbubble.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ChowApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.INFO)
            androidContext(androidContext = this@ChowApplication)
            modules(modules = appModule)
        }
    }
}