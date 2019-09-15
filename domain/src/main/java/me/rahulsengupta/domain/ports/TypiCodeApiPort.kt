package me.rahulsengupta.domain.ports

import me.rahulsengupta.abstractor.dto.Photo
import me.rahulsengupta.abstractor.core.retrofit.NetworkResponse

interface TypiCodeApiPort {
    fun getPhotos(): NetworkResponse<List<Photo>>
}