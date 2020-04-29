package com.darklabs.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("categories")
    suspend fun getJokeCategories(): Response<List<String>>
}