package me.rahulsengupta.persistence

import android.app.Application
import androidx.room.Room
import me.rahulsengupta.domain.ports.PhotoDaoPort
import me.rahulsengupta.persistence.adapter.PhotoDaoAdapter
import org.koin.core.module.Module
import org.koin.dsl.module

object PersistenceModules {

    private val databaseModule = module {
        single {
            val application = get<Application>()
            Room.databaseBuilder(
                application,
                ArchitectureSampleDatabase::class.java,
                DatabaseMeta.NAME
            ).build()
        }
    }

    private val daoModules = module {
        single { get<ArchitectureSampleDatabase>().photoDao() }
    }

    private val portsModule = module {
        single<PhotoDaoPort> { PhotoDaoAdapter(get()) }
    }

    val modules: List<Module> = listOf(databaseModule, daoModules, portsModule)
}