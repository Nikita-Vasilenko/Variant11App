package com.example.variant11app.presentation.main

import androidx.lifecycle.ViewModel
import com.example.variant11app.presentation.util.NavigationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class MainViewModel : ViewModel() {

    private val _events = Channel<NavigationEvent>(Channel.UNLIMITED)
    val events = _events.receiveAsFlow()

    fun onReverseClicked() = _events.trySend(NavigationEvent.Reverse)

    fun onAboutClicked() = _events.trySend(NavigationEvent.About)

    fun onExitClicked() = _events.trySend(NavigationEvent.Back)
}