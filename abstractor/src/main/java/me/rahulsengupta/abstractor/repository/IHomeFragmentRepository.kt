package me.rahulsengupta.abstractor.repository

import me.rahulsengupta.abstractor.core.retrofit.NetworkResponse
import me.rahulsengupta.abstractor.dto.Photo

interface IHomeFragmentRepository {
    fun getPhotos(): NetworkResponse<List<Photo>>
    fun getPhotosFromDb(): List<Photo>
    fun savePhoto(photo: Photo)
}