package com.darklabs.jokepack.di

import com.darklabs.jokepack.data.category.CategoryRepository
import com.darklabs.jokepack.data.category.CategoryRepositoryImpl
import org.koin.dsl.module

val appModule = module { single<CategoryRepository> { CategoryRepositoryImpl(get()) } }