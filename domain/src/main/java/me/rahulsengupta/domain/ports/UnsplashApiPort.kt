package me.rahulsengupta.domain.ports

import me.rahulsengupta.abstractor.core.retrofit.NetworkResponse
import me.rahulsengupta.abstractor.dto.Collection

interface UnsplashApiPort {
    fun getCollections(page: Int, perPage: Int): NetworkResponse<List<Collection>>
}