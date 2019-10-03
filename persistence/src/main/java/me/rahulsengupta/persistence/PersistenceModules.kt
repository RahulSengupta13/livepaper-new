package me.rahulsengupta.persistence

import me.rahulsengupta.domain.ports.PreferenceStoragePort
import me.rahulsengupta.persistence.preferences.SharedPreferencesStorage
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object PersistenceModules {

    private val portsModule = module {
        single<PreferenceStoragePort> { SharedPreferencesStorage(androidContext()) }
    }

    val modules: List<Module> = listOf(portsModule)
}
