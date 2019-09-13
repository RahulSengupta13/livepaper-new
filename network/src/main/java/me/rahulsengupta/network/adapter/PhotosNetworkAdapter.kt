package me.rahulsengupta.network.adapter

import me.rahulsengupta.domain.core.retrofit.getRetrofitResult
import me.rahulsengupta.domain.ports.PhotoNetworkPort
import me.rahulsengupta.network.service.PhotoService

internal class PhotosNetworkAdapter(private val photoService: PhotoService) : PhotoNetworkPort {
    override fun getPhotos() = photoService.getPhotos().getRetrofitResult()
}