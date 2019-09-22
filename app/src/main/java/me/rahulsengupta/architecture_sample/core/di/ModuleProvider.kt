package me.rahulsengupta.architecture_sample.core.di

import me.rahulsengupta.architecture_sample.splash.SplashFragmentAvm
import me.rahulsengupta.di.HomeModules
import me.rahulsengupta.domain.core.di.DomainModules
import me.rahulsengupta.network.core.di.NetworkModules
import me.rahulsengupta.persistence.PersistenceModules
import me.rahulsengupta.settings.di.SettingsModule
import me.rahulsengupta.shared.di.SharedModules
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ModuleProvider {

    private val appModules = module {
        viewModel { SplashFragmentAvm(get(), get()) }
    }

    val modules: List<Module>
        get() {
            return ArrayList<Module>().apply {
                add(appModules)
                addAll(DomainModules.modules)
                addAll(NetworkModules.modules)
                addAll(PersistenceModules.modules)
                addAll(SharedModules.modules)
                addAll(HomeModules.modules)
                addAll(SettingsModule.modules)
            }
        }
}