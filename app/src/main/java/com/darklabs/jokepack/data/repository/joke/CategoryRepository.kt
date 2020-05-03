package com.darklabs.jokepack.data.repository.joke

import com.darklabs.network.Joke

interface CategoryRepository {
    suspend fun getJokeCategories(): List<String>
    suspend fun getJokeForCategory(category: String): Joke
}