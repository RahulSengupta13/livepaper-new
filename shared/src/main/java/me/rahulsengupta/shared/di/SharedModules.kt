package me.rahulsengupta.shared.di

import me.rahulsengupta.shared.theme.IThemeHelper
import me.rahulsengupta.shared.theme.ThemeHelper
import org.koin.dsl.module

object SharedModules {

    private val sharedModules = module {
        single<IThemeHelper> { ThemeHelper() }
    }

    val modules = listOf(sharedModules)
}