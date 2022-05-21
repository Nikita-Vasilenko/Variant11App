package com.example.variant11app.di

import com.example.variant11app.data.developer.DeveloperRepository
import com.example.variant11app.data.message.MessageRepository
import com.example.variant11app.data.reverseSettings.ReverseSettingsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<DeveloperRepository> { DeveloperRepository(get()) }
    single<MessageRepository> { MessageRepository(get()) }
    single<ReverseSettingsRepository> { ReverseSettingsRepository(get()) }
}