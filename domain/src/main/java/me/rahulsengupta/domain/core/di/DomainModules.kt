package me.rahulsengupta.domain.core.di

import me.rahulsengupta.abstractor.repository.IHomeFragmentRepository
import me.rahulsengupta.abstractor.repository.ISharedPreferencesRepository
import me.rahulsengupta.domain.repository.HomeFragmentRepository
import me.rahulsengupta.domain.repository.SharedPreferencesRepository
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModules {

    private val homeFragmentModules = module {
        single<IHomeFragmentRepository> { HomeFragmentRepository(get()) }
    }

    private val sharedPrefModule = module {
        single<ISharedPreferencesRepository> { SharedPreferencesRepository(get()) }
    }

    val modules: List<Module>
        get() = listOf(
            homeFragmentModules,
            sharedPrefModule
        )
}