package com.darklabs.jokepack.data.repository.joke

import com.darklabs.network.ApiInterface
import com.darklabs.network.Joke


class CategoryRepositoryImpl(private val apiInterface: ApiInterface) : CategoryRepository {

    override suspend fun getJokeCategories(): List<String> {
        return apiInterface.getJokeCategories().body()!!
    }

    override suspend fun getJokeForCategory(category: String): Joke {
        return apiInterface.getJoke(category).body()!!
    }
}