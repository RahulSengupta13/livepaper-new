package me.rahulsengupta.settings.theme.model

import me.rahulsengupta.shared.theme.Theme

data class ThemeDialogViewModel(
    val theme: Theme,
    val darkChecked: Boolean,
    val lightChecked: Boolean,
    val systemChecked: Boolean
)