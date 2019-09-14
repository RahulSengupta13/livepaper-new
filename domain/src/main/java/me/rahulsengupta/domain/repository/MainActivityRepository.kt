package me.rahulsengupta.domain.repository

import me.rahulsengupta.abstractor.dto.Photo
import me.rahulsengupta.abstractor.repository.IMainActivityRepository
import me.rahulsengupta.domain.ports.PhotoDaoPort
import me.rahulsengupta.domain.ports.TypiCodeApiPort

internal class MainActivityRepository(
    private val networkPort: TypiCodeApiPort,
    private val dbPort: PhotoDaoPort
) : IMainActivityRepository {
    override fun savePhoto(photo: Photo) = dbPort.savePhoto(photo)
    override fun getPhotos() = networkPort.getPhotos()
    override fun getPhotosFromDb() = dbPort.getPhotos()
}