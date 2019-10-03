package me.rahulsengupta.livepaper

import android.app.Application
import android.os.StrictMode
import me.rahulsengupta.livepaper.core.di.ModuleProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class LivePaperApplication : Application() {

    override fun onCreate() {
        if(BuildConfig.DEBUG) {
//            enableStrictMode()
        }

        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            printLogger()
            androidContext(this@LivePaperApplication)
            modules(ModuleProvider.modules)
        }
    }

    private fun enableStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build()
        )
    }
}