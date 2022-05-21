package com.example.variant11app.data.developer

import androidx.datastore.core.DataStore
import com.example.variant11app.data.DeveloperPreferences
import com.example.variant11app.data.toDomain
import com.example.variant11app.domain.Developer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DeveloperRepository(
    private val dataStore: DataStore<DeveloperPreferences>
) {
    val reverseSettings: Flow<Developer> = dataStore.data.map { prefs -> prefs.toDomain() }
}