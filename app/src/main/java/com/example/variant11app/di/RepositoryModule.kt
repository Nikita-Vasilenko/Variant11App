package com.example.variant11app.di

import com.example.variant11app.data.developer.DeveloperRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single { DeveloperRepository(androidContext()) }
}