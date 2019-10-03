package me.rahulsengupta.network.model

import me.rahulsengupta.abstractor.dto.Image

data class ImageResponse(
    override val medium: String?,
    override val large: String?
) : Image