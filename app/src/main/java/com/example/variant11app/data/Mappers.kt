package com.example.variant11app.data

import com.example.variant11app.domain.Developer
import com.example.variant11app.domain.Message
import com.example.variant11app.domain.ReverseSettings

fun DeveloperPreferences.toDomain(): Developer? {
    return if (this.name.isEmpty() || this.message.isEmpty() || this.groupName.isEmpty()) null
    else Developer(this.name, this.groupName, this.message)
}

fun MessagePreferences.toDomain() = Message(this.text)

fun ReverseSettingsPreferences.toDomain() = ReverseSettings(this.isReverse, this.isUpperCase)

