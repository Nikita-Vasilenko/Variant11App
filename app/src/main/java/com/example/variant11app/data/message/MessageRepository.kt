package com.example.variant11app.data.message

import androidx.datastore.core.DataStore
import com.example.variant11app.data.MessagePreferences
import com.example.variant11app.data.toDomain
import com.example.variant11app.domain.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MessageRepository(
    private val dataStore: DataStore<MessagePreferences>
) {
    val message: Flow<Message> = dataStore.data.map { prefs -> prefs.toDomain() }


    suspend fun setReverseSettings(message: Message) = dataStore.updateData { prefs ->
        prefs.toBuilder()
            .setText(message.text)
            .build()
    }
}