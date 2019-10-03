package me.rahulsengupta.network.adapter

import me.rahulsengupta.abstractor.core.retrofit.getResult
import me.rahulsengupta.domain.ports.UnsplashApiPort
import me.rahulsengupta.network.service.UnsplashEndpoints

internal class UnsplashAdapter(private val endpoints: UnsplashEndpoints) : UnsplashApiPort {

    override fun getCollections(page: Int, perPage: Int) =
        endpoints.getCollections(page, perPage).getResult()

}