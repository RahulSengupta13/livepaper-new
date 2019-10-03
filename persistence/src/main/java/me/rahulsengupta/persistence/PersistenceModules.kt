package me.rahulsengupta.persistence

import android.app.Application
import androidx.room.Room
import me.rahulsengupta.domain.ports.PhotoDaoPort
import me.rahulsengupta.domain.ports.PreferenceStoragePort
import me.rahulsengupta.persistence.adapter.PhotoDaoAdapter
import me.rahulsengupta.persistence.preferences.SharedPreferencesStorage
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object PersistenceModules {

    private val databaseModule = module {
        single {
            val application = get<Application>()
            Room.databaseBuilder(
                application,
                LivePaperDatabase::class.java,
                DatabaseMeta.NAME
            ).build()
        }
    }

    private val daoModules = module {
        single { get<LivePaperDatabase>().photoDao() }
    }

    private val portsModule = module {
        single<PhotoDaoPort> { PhotoDaoAdapter(get()) }
        single<PreferenceStoragePort> { SharedPreferencesStorage(androidContext()) }
    }

    val modules: List<Module> = listOf(databaseModule, daoModules, portsModule)
}