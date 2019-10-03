package me.rahulsengupta.abstractor.dto

interface Collection {
    val id: Int
    val title: String?
    val description: String?
    val user: User?
    val coverPhoto: CoverPhoto
    val publishedAt: String?
    val totalPhotos: Int?
}