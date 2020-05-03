package com.darklabs.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("categories")
    suspend fun getJokeCategories(): Response<List<String>>

    @GET("random")
    suspend fun getJoke(@Query("category") category: String): Response<Joke>
}