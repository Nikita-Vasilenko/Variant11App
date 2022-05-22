package com.example.variant11app.data.developer

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.variant11app.data.DeveloperPreferences
import com.example.variant11app.domain.Developer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DeveloperRepository(private val context: Context) {

    companion object {
        private const val DEVELOPER_PREFERENCES_NAME = "developer_preferences.pb"
    }

    private val Context.dataStore: DataStore<DeveloperPreferences> by dataStore(
        DEVELOPER_PREFERENCES_NAME,
        DeveloperPreferencesSerializer
    )

    val developer: Flow<Developer?> = context.dataStore.data.map { prefs -> prefs.toDomain() }


    suspend fun setDeveloper(developer: Developer) = context.dataStore.updateData { prefs ->
        prefs.toBuilder()
            .setName(developer.name)
            .setMessage(developer.message)
            .setGroupName(developer.groupName)
            .build()
    }

    private fun DeveloperPreferences.toDomain(): Developer? {
        return if (this.name.isEmpty() || this.message.isEmpty() || this.groupName.isEmpty()) null
        else Developer(this.name, this.groupName, this.message)
    }
}