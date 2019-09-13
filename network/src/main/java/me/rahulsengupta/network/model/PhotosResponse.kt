package me.rahulsengupta.network.model

import me.rahulsengupta.abstractor.dto.Photo

data class PhotosResponse(
    override val albumId: Int,
    override val id: Int,
    override val title: String,
    override val url: String
) : Photo