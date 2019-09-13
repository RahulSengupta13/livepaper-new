package me.rahulsengupta.domain.core.di

import me.rahulsengupta.abstractor.repository.PhotoNetwork
import me.rahulsengupta.domain.logic.PhotoNetworkAdapter
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModules {

    private val networkModules = module {
        single<PhotoNetwork> { PhotoNetworkAdapter(get()) }
    }

    val modules: List<Module>
        get() = listOf(networkModules)
}