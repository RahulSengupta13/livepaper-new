package me.rahulsengupta.network.model

import me.rahulsengupta.abstractor.dto.User

data class UserResponse(
    override val name: String?,
    override val image: ImageResponse?,
    override val twitterUsername: String?,
    override val instagramUsername: String?
) : User