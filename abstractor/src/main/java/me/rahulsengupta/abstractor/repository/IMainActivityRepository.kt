package me.rahulsengupta.abstractor.repository

import me.rahulsengupta.abstractor.core.retrofit.RetrofitResult
import me.rahulsengupta.abstractor.dto.Photo

interface IMainActivityRepository {
    fun getPhotos(): RetrofitResult<List<Photo>>
    fun getPhotosFromDb(): List<Photo>
    fun savePhoto(photo: Photo)
}