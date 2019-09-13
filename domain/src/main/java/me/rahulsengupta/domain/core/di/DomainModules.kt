package me.rahulsengupta.domain.core.di

import me.rahulsengupta.abstractor.repository.ITypiCodeRepository
import me.rahulsengupta.domain.repository.TypiCodeApiRepository
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModules {

    private val networkModules = module {
        single<ITypiCodeRepository> { TypiCodeApiRepository(get()) }
    }

    val modules: List<Module>
        get() = listOf(networkModules)
}