package com.example.variant11app.di

import com.example.variant11app.presentation.about.AboutViewModel
import com.example.variant11app.presentation.main.MainViewModel
import com.example.variant11app.presentation.reverse.ReverseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { AboutViewModel(get()) }
    viewModel { ReverseViewModel() }
}