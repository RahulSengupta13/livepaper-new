package me.rahulsengupta.network.adapter

import me.rahulsengupta.abstractor.core.retrofit.getRetrofitResult
import me.rahulsengupta.domain.ports.PhotoApiPort
import me.rahulsengupta.network.service.PhotoService

internal class PhotoApiAdapter(private val photoService: PhotoService) : PhotoApiPort {
    override fun getPhotos() = photoService.getPhotos().getRetrofitResult()
}