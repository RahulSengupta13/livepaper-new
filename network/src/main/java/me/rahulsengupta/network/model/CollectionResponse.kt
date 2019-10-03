package me.rahulsengupta.network.model

import me.rahulsengupta.abstractor.dto.Collection

data class CollectionResponse(
    override val id: Int,
    override val title: String?,
    override val description: String?,
    override val user: UserResponse?,
    override val coverPhoto: CoverPhotoResponse,
    override val publishedAt: String?,
    override val totalPhotos: Int?
) : Collection