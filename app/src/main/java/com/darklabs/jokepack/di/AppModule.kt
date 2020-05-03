package com.darklabs.jokepack.di

import com.darklabs.jokepack.data.repository.joke.CategoryRepository
import com.darklabs.jokepack.data.repository.joke.CategoryRepositoryImpl
import org.koin.dsl.module

val appModule = module {
    single<CategoryRepository> {
        CategoryRepositoryImpl(get())
    }
}