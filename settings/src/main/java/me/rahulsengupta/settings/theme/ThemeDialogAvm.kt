package me.rahulsengupta.settings.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.rahulsengupta.abstractor.repository.ISharedPreferencesRepository
import me.rahulsengupta.settings.theme.model.ThemeDialogViewModel
import me.rahulsengupta.shared.coroutine.ScopedViewModel
import me.rahulsengupta.shared.theme.IThemeHelper
import me.rahulsengupta.shared.theme.Theme

class ThemeDialogAvm(
    sharedPreferencesRepository: ISharedPreferencesRepository,
    themeHelper: IThemeHelper
) : ScopedViewModel() {

    private val logic: ThemeDialogLogic

    private val _present = MutableLiveData<ThemeDialogViewModel>()
    val present: LiveData<ThemeDialogViewModel> = _present
    private val _finish = MutableLiveData<Unit>()
    val finish: LiveData<Unit> = _finish

    init {
        val listener = object : ThemeDialogLogic.Listener {
            override fun finish() = _finish.postValue(Unit)
            override fun present(viewModel: ThemeDialogViewModel) = _present.postValue(viewModel)
        }
        logic = ThemeDialogLogic(sharedPreferencesRepository, listener, themeHelper)
    }

    fun setup() = logic.setup()
    fun onApplyClicked() = logic.onApplyClicked()
    fun onCancelClicked() = logic.onCancelClicked()
    fun onRadioClicked(theme: Theme) = logic.onRadioClicked(theme)
}