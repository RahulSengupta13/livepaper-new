package me.rahulsengupta.livepaper.splash

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.rahulsengupta.abstractor.repository.ISharedPreferencesRepository
import me.rahulsengupta.shared.coroutine.ScopedViewModel
import me.rahulsengupta.shared.theme.IThemeHelper
import me.rahulsengupta.shared.theme.Theme
import java.util.concurrent.TimeUnit

class SplashFragmentAvm(
    private val sharedPreferencesRepository: ISharedPreferencesRepository,
    private val themeHelper: IThemeHelper
) : ScopedViewModel() {

    private val _finish: MutableLiveData<Unit> = MutableLiveData()
    val finish
        get() = _finish

    fun setup() {
        coroutineScope.launch {
            when (sharedPreferencesRepository.getTheme()) {
                Theme.DARK.themeName -> themeHelper.applyTheme(Theme.DARK)
                Theme.SYSTEM.themeName -> themeHelper.applyTheme(Theme.SYSTEM)
                else -> themeHelper.applyTheme(Theme.LIGHT)
            }
            delay(TimeUnit.SECONDS.toMillis(2))
            finish.postValue(Unit)
        }
    }
}