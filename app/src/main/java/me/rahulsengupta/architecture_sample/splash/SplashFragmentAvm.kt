package me.rahulsengupta.architecture_sample.splash

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.rahulsengupta.shared.coroutine.ScopedViewModel
import java.util.concurrent.TimeUnit

class SplashFragmentAvm : ScopedViewModel() {
    //private val repo: IHomeFragmentRepository

    private val _finish: MutableLiveData<Unit> = MutableLiveData()
    val finish
        get() = _finish

    fun setup() {
        coroutineScope.launch {
            delay(TimeUnit.SECONDS.toMillis(1))
            finish.postValue(Unit)
        }
    }
}