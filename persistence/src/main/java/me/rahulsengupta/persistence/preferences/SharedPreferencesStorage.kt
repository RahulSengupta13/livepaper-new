package me.rahulsengupta.persistence.preferences

import android.content.Context
import me.rahulsengupta.domain.ports.PreferenceStoragePort

class SharedPreferencesStorage(context: Context) : PreferenceStoragePort {

    companion object {
        private const val PREFERENCES = "ArchitectureSamplePreferences"
        private const val THEME = "Theme"
    }

    private val prefs = context.applicationContext
        .getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)


    override var theme by StringPreference(prefs, THEME, "light")
}