package me.rahulsengupta.network.service

import me.rahulsengupta.network.model.CollectionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashEndpoints {

    @GET("collections")
    fun getCollections(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<List<CollectionResponse>>
}