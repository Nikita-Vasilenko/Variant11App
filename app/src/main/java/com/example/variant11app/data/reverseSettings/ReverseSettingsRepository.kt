package com.example.variant11app.data.reverseSettings

import androidx.datastore.core.DataStore
import com.example.variant11app.data.ReverseSettingsPreferences
import com.example.variant11app.data.toDomain
import com.example.variant11app.domain.ReverseSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ReverseSettingsRepository(
    private val dataStore: DataStore<ReverseSettingsPreferences>
) {
    val reverseSettings: Flow<ReverseSettings> = dataStore.data.map { prefs -> prefs.toDomain() }


    suspend fun setReverseSettings(settings: ReverseSettings) = dataStore.updateData { prefs ->
        prefs.toBuilder()
            .setIsReverse(settings.isReverseOrder)
            .setIsUpperCase(settings.isUpperCase)
            .build()
    }
}