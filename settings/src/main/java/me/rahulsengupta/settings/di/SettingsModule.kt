package me.rahulsengupta.settings.di

import me.rahulsengupta.settings.SettingsFragmentAvm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object SettingsModule {
    private val settingsModule = module {
        viewModel { SettingsFragmentAvm(get()) }
    }

    val modules = listOf(settingsModule)
}