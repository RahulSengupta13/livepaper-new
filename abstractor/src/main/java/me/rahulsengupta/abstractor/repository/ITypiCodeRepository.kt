package me.rahulsengupta.abstractor.repository

import me.rahulsengupta.abstractor.core.retrofit.RetrofitResult
import me.rahulsengupta.abstractor.dto.Photo

interface ITypiCodeRepository {
    fun getPhotos(): RetrofitResult<List<Photo>>
}