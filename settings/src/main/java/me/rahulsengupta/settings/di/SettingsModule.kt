package me.rahulsengupta.settings.di

import me.rahulsengupta.settings.SettingsFragmentAvm
import me.rahulsengupta.settings.theme.ThemeDialogAvm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object SettingsModule {
    private val settingsModule = module {
        viewModel { SettingsFragmentAvm(get()) }
        viewModel { ThemeDialogAvm(get(), get()) }
    }

    val modules = listOf(settingsModule)
}