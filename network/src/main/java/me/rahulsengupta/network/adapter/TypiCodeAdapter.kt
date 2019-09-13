package me.rahulsengupta.network.adapter

import me.rahulsengupta.abstractor.core.retrofit.getRetrofitResult
import me.rahulsengupta.domain.ports.TypiCodeApiPort
import me.rahulsengupta.network.service.TypicodeEndpoints

internal class TypiCodeAdapter(private val typiCodeEndpoints: TypicodeEndpoints) : TypiCodeApiPort {
    override fun getPhotos() = typiCodeEndpoints.getPhotos().getRetrofitResult()
}