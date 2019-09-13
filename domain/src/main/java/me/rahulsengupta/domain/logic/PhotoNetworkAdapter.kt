package me.rahulsengupta.domain.logic

import me.rahulsengupta.abstractor.repository.PhotoNetwork
import me.rahulsengupta.domain.ports.PhotoNetworkPort

internal class PhotoNetworkAdapter(
    private val port: PhotoNetworkPort
) : PhotoNetwork {

    override fun getPhotos() {
        port.getPhotos()
    }
}