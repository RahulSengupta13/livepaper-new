package me.rahulsengupta.domain.ports

import me.rahulsengupta.abstractor.dto.Photo
import me.rahulsengupta.abstractor.core.retrofit.RetrofitResult

interface PhotoApiPort {
    fun getPhotos(): RetrofitResult<List<Photo>>
}