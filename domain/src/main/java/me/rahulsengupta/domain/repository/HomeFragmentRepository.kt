package me.rahulsengupta.domain.repository

import me.rahulsengupta.abstractor.dto.Photo
import me.rahulsengupta.abstractor.repository.IHomeFragmentRepository
import me.rahulsengupta.domain.ports.PhotoDaoPort
import me.rahulsengupta.domain.ports.TypiCodeApiPort

internal class HomeFragmentRepository(
    private val networkPort: TypiCodeApiPort,
    private val photoDaoPort: PhotoDaoPort
) : IHomeFragmentRepository {
    override fun savePhoto(photo: Photo) = photoDaoPort.savePhoto(photo)
    override fun getPhotos() = networkPort.getPhotos()
    override fun getPhotosFromDb() = photoDaoPort.getPhotos()
}