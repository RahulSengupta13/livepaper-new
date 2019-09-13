package me.rahulsengupta.architecture_sample

import android.app.Application
import me.rahulsengupta.architecture_sample.core.di.ModuleProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger()
            androidContext(this@SampleApplication)
            modules(ModuleProvider.modules)
        }
    }
}