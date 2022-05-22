package com.example.variant11app.presentation.reverse

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class ReverseViewModel : ViewModel() {

    private var _message = MutableStateFlow<String>("")
    val message = _message.asStateFlow()

    val isCaseCheckboxEnabled = message.map { it.isNotEmpty() }
    val isOrderCheckboxEnabled = message.map { it.isNotEmpty() }


    fun onUpperCaseChecked(isChecked: Boolean) {
        _message.update { if (isChecked) it.uppercase() else it.lowercase() }
    }

    fun onReverseChecked() = _message.update { it.reversed() }

    fun onInputChanged(input: String) = _message.update { input }
}