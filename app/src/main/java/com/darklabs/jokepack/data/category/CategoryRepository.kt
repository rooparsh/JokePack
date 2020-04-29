package com.darklabs.jokepack.data.category

interface CategoryRepository {
    suspend fun getJokeCategories(): List<String>
}