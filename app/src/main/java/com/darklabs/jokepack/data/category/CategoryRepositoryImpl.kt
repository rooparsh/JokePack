package com.darklabs.jokepack.data.category

import com.darklabs.network.ApiInterface


class CategoryRepositoryImpl(private val apiInterface: ApiInterface) : CategoryRepository {

    override suspend fun getJokeCategories(): List<String> {
        return apiInterface.getJokeCategories().body()!!
    }
}