package me.rahulsengupta.settings.theme

import me.rahulsengupta.abstractor.repository.ISharedPreferencesRepository
import me.rahulsengupta.shared.theme.IThemeHelper
import me.rahulsengupta.shared.theme.Theme
import me.rahulsengupta.settings.theme.model.ThemeDialogViewModel
import java.util.*

class ThemeDialogLogic(
    private val sharedPreferencesRepository: ISharedPreferencesRepository,
    private val listener: Listener,
    private val themeHelper: IThemeHelper
) {

    var theme: Theme? = null

    interface Listener {
        fun present(viewModel: ThemeDialogViewModel)
        fun finish()
    }

    fun setup() {
        val currentTheme = getThemeViewModel(sharedPreferencesRepository.getTheme())
        theme = currentTheme.theme
        listener.present(currentTheme)
    }

    fun onRadioClicked(theme: Theme) {
        this.theme = theme
        listener.present(getThemeViewModel(theme.themeName))
    }

    fun onCancelClicked() = listener.finish()

    fun onApplyClicked() {
        theme?.let {
            themeHelper.applyTheme(it)
            sharedPreferencesRepository.setTheme(it.themeName)
        }
        listener.finish()
    }

    companion object {
        fun getThemeViewModel(theme: String?): ThemeDialogViewModel {
            return when (theme?.toLowerCase(Locale.US)) {
                Theme.DARK.themeName -> {
                    ThemeDialogViewModel(
                        Theme.DARK,
                        darkChecked = true,
                        lightChecked = false,
                        systemChecked = false
                    )
                }
                Theme.SYSTEM.themeName -> {
                    ThemeDialogViewModel(
                        Theme.SYSTEM,
                        darkChecked = false,
                        lightChecked = false,
                        systemChecked = true
                    )
                }
                else -> {
                    ThemeDialogViewModel(
                        Theme.LIGHT,
                        darkChecked = false,
                        lightChecked = true,
                        systemChecked = false
                    )
                }
            }
        }
    }
}