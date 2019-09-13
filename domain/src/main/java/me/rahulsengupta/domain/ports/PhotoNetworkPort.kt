package me.rahulsengupta.domain.ports

import me.rahulsengupta.abstractor.dto.Photo
import me.rahulsengupta.domain.core.retrofit.RetrofitResult

interface PhotoNetworkPort {
    fun getPhotos(): RetrofitResult<List<Photo>>
}