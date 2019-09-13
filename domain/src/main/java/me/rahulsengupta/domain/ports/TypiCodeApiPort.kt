package me.rahulsengupta.domain.ports

import me.rahulsengupta.abstractor.dto.Photo
import me.rahulsengupta.abstractor.core.retrofit.RetrofitResult

interface TypiCodeApiPort {
    fun getPhotos(): RetrofitResult<List<Photo>>
}