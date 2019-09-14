package me.rahulsengupta.persistence.adapter

import me.rahulsengupta.abstractor.dto.Photo
import me.rahulsengupta.domain.ports.PhotoDaoPort
import me.rahulsengupta.persistence.dao.PhotoDao
import me.rahulsengupta.persistence.entity.PhotoEntity

internal class PhotoDaoAdapter(private val dao: PhotoDao) : PhotoDaoPort {

    override fun getPhotos() = dao.getPhotos()

    override fun savePhoto(photo: Photo) {
        when (photo) {
            is PhotoEntity -> dao.insertOrReplace(photo)
            else -> {
                dao.insertOrReplace(
                    PhotoEntity(
                        photo.id,
                        photo.albumId,
                        photo.title,
                        photo.url
                    )
                )
            }
        }
    }
}