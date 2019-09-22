package me.rahulsengupta.shared.theme

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.BuildCompat.isAtLeastQ

interface IThemeHelper {
    fun applyTheme(theme: Theme)
}

class ThemeHelper : IThemeHelper {
    override fun applyTheme(theme: Theme) {
        when (theme.themeName) {
            Theme.LIGHT.themeName -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            Theme.DARK.themeName -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            Theme.SYSTEM.themeName -> {
                if (isAtLeastQ()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
                }
            }
        }
    }
}