package me.rahulsengupta.domain.repository

import me.rahulsengupta.abstractor.repository.PhotoApi
import me.rahulsengupta.domain.ports.PhotoApiPort

internal class PhotoApiRepository(
    private val port: PhotoApiPort
) : PhotoApi {

    override fun getPhotos() = port.getPhotos()
}