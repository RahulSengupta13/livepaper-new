package me.rahulsengupta.domain.ports

import me.rahulsengupta.abstractor.dto.Photo

interface PhotoDaoPort {
    fun getPhotos(): List<Photo>
    fun savePhoto(photo: Photo)
}