package com.example.variant11app.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.variant11app.data.DeveloperPreferences
import com.example.variant11app.data.MessagePreferences
import com.example.variant11app.data.ReverseSettingsPreferences
import com.example.variant11app.data.developer.DeveloperPreferencesSerializer
import com.example.variant11app.data.message.MessagePreferencesSerializer
import com.example.variant11app.data.reverseSettings.ReverseSettingsPreferencesSerializer
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val DEVELOPER_PREFERENCES_NAME = "developer_preferences.pb"
private const val MESSAGE_PREFERENCES_NAME = "message_preferences.pb"
private const val REVERSE_SETTINGS_PREFERENCES_NAME = "reverse_settings_preferences.pb"

private val Context.developerPreferences: DataStore<DeveloperPreferences> by dataStore(
    DEVELOPER_PREFERENCES_NAME,
    DeveloperPreferencesSerializer
)

private val Context.messagePreferences: DataStore<MessagePreferences> by dataStore(
    MESSAGE_PREFERENCES_NAME,
    MessagePreferencesSerializer
)

private val Context.reverseSettingsPreferences: DataStore<ReverseSettingsPreferences> by dataStore(
    REVERSE_SETTINGS_PREFERENCES_NAME,
    ReverseSettingsPreferencesSerializer
)

val dataStoreModule = module {
    single<DataStore<DeveloperPreferences>> { androidContext().developerPreferences }

    single<DataStore<MessagePreferences>> { androidContext().messagePreferences }

    single<DataStore<ReverseSettingsPreferences>> { androidContext().reverseSettingsPreferences }
}