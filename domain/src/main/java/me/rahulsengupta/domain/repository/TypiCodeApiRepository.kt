package me.rahulsengupta.domain.repository

import me.rahulsengupta.abstractor.repository.ITypiCodeRepository
import me.rahulsengupta.domain.ports.TypiCodeApiPort

internal class TypiCodeApiRepository(
    private val port: TypiCodeApiPort
) : ITypiCodeRepository {
    override fun getPhotos() = port.getPhotos()
}