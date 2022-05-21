package com.example.variant11app.data.message

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.variant11app.data.MessagePreferences
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object MessagePreferencesSerializer : Serializer<MessagePreferences> {
    override val defaultValue: MessagePreferences
        get() = MessagePreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): MessagePreferences {
        try {
            return MessagePreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: MessagePreferences, output: OutputStream) = t.writeTo(output)
}