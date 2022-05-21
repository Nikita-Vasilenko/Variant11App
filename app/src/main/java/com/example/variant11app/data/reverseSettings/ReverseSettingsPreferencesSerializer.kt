package com.example.variant11app.data.reverseSettings

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.variant11app.data.ReverseSettingsPreferences
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object ReverseSettingsPreferencesSerializer : Serializer<ReverseSettingsPreferences> {
    override val defaultValue: ReverseSettingsPreferences
        get() = ReverseSettingsPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): ReverseSettingsPreferences {
        try {
            return ReverseSettingsPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: ReverseSettingsPreferences, output: OutputStream) = t.writeTo(output)
}