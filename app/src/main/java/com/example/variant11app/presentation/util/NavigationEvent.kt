package com.example.variant11app.presentation.util

sealed class NavigationEvent {
    object Reverse : NavigationEvent()
    object About : NavigationEvent()
    object Back : NavigationEvent()
}
