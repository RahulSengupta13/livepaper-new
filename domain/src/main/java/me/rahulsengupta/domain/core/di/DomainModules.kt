package me.rahulsengupta.domain.core.di

import me.rahulsengupta.abstractor.repository.PhotoApi
import me.rahulsengupta.domain.repository.PhotoApiRepository
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModules {

    private val networkModules = module {
        single<PhotoApi> { PhotoApiRepository(get()) }
    }

    val modules: List<Module>
        get() = listOf(networkModules)
}