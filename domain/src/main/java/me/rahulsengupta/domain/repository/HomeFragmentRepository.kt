package me.rahulsengupta.domain.repository

import me.rahulsengupta.abstractor.repository.IHomeFragmentRepository
import me.rahulsengupta.domain.ports.UnsplashApiPort

internal class HomeFragmentRepository(
    private val networkPort: UnsplashApiPort
) : IHomeFragmentRepository {
    override fun getCollections(page: Int, perPage: Int) = networkPort.getCollections(page, perPage)
}