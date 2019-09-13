package me.rahulsengupta.network.service

import me.rahulsengupta.network.model.PhotosResponse
import retrofit2.Call
import retrofit2.http.GET

interface TypicodeEndpoints {

    @GET("photos")
    fun getPhotos(): Call<List<PhotosResponse>>
}