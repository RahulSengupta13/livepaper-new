package me.rahulsengupta.di

import me.rahulsengupta.home.HomeFragmentAvm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object HomeModules {
    private val homeFragmentModule = module {
        viewModel { HomeFragmentAvm(get()) }
    }

    val modules = listOf(homeFragmentModule)
}