package com.example.variant11app.data

import com.example.variant11app.domain.Developer
import com.example.variant11app.domain.Message
import com.example.variant11app.domain.ReverseSettings

fun DeveloperPreferences.toDomain() = Developer(this.name)

fun MessagePreferences.toDomain() = Message(this.text)

fun ReverseSettingsPreferences.toDomain() = ReverseSettings(this.isReverse, this.isUpperCase)

