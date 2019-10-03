package me.rahulsengupta.network.model

import me.rahulsengupta.abstractor.dto.CoverPhoto

data class CoverPhotoResponse(
    override val urls: UrlsResponse
) : CoverPhoto