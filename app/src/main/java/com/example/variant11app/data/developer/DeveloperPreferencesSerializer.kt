@file:Suppress("BlockingMethodInNonBlockingContext")

package com.example.variant11app.data.developer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.variant11app.data.DeveloperPreferences
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object DeveloperPreferencesSerializer : Serializer<DeveloperPreferences> {
    override val defaultValue: DeveloperPreferences
        get() = DeveloperPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): DeveloperPreferences {
        try {
            return DeveloperPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: DeveloperPreferences, output: OutputStream) = t.writeTo(output)
}