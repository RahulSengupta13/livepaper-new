package me.rahulsengupta.settings

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.rahulsengupta.abstractor.repository.ISharedPreferencesRepository
import me.rahulsengupta.shared.coroutine.ScopedViewModel

class SettingsFragmentAvm(
    private val sharedPreferencesRepository: ISharedPreferencesRepository
) : ScopedViewModel() {

    fun setup() {
        coroutineScope.launch(Dispatchers.Default) {
        }
    }
}