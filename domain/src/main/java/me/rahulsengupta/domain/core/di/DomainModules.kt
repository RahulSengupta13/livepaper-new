package me.rahulsengupta.domain.core.di

import me.rahulsengupta.abstractor.repository.IMainActivityRepository
import me.rahulsengupta.domain.repository.MainActivityRepository
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModules {

    private val networkModules = module {
        single<IMainActivityRepository> { MainActivityRepository(get(), get()) }
    }

    val modules: List<Module>
        get() = listOf(networkModules)
}