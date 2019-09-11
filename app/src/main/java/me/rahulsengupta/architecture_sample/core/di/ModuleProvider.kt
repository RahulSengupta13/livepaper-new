package me.rahulsengupta.architecture_sample.core.di

import android.content.ContentResolver
import me.rahulsengupta.domain.core.di.DomainModules
import me.rahulsengupta.network.core.di.NetworkModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object ModuleProvider {

    private val appModules = module {
        single<ContentResolver> { androidContext().contentResolver }
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