package com.example.variant11app.presentation.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.variant11app.data.developer.DeveloperRepository
import com.example.variant11app.domain.Developer
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class AboutViewModel(
    private val developerRepository: DeveloperRepository
) : ViewModel() {

    private val developer = developerRepository.developer
    val name = developer.mapNotNull { it?.name }
    val message = developer.mapNotNull { it?.message }
    val groupName = developer.mapNotNull { it?.groupName }


    init {
        developer.onEach { if (it == null) saveDeveloper() }.launchIn(viewModelScope)
    }

    private fun saveDeveloper() = viewModelScope.launch {
        developerRepository.setDeveloper(Developer())
    }
}