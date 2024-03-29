package me.rahulsengupta.abstractor.repository

import me.rahulsengupta.abstractor.core.retrofit.NetworkResponse
import me.rahulsengupta.abstractor.dto.Collection

interface IHomeFragmentRepository {
    fun getCollections(page: Int, perPage: Int): NetworkResponse<List<Collection>>
}