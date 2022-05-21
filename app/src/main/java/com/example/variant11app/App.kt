package com.example.variant11app

import android.app.Application
import com.example.variant11app.di.dataStoreModule
import com.example.variant11app.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(dataStoreModule, repositoryModule)
        }
    }
}