package me.rahulsengupta.domain.repository

import me.rahulsengupta.abstractor.repository.ISharedPreferencesRepository
import me.rahulsengupta.domain.ports.PreferenceStoragePort

class SharedPreferencesRepository(
    private val sharedPreferenceStoragePort: PreferenceStoragePort
) : ISharedPreferencesRepository {

    override fun getTheme() = sharedPreferenceStoragePort.theme

    override fun setTheme(theme: String) {
        sharedPreferenceStoragePort.theme = theme
    }
}