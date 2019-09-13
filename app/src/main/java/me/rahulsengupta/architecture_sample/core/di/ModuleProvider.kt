package me.rahulsengupta.architecture_sample.core.di

import me.rahulsengupta.architecture_sample.main.MainActivityAvm
import me.rahulsengupta.domain.core.di.DomainModules
import me.rahulsengupta.network.core.di.NetworkModules
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ModuleProvider {

    private val appModules = module {
        viewModel { MainActivityAvm(get()) }
    }

    val modules: List<Module>
        get() {
            return ArrayList<Module>().apply {
                add(appModules)
                addAll(DomainModules.modules)
                addAll(NetworkModules.modules)
            }
        }
}