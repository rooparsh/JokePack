package com.darklabs.jokepack.di

import com.darklabs.jokepack.ui.MainViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}