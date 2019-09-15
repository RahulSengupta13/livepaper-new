package me.rahulsengupta.architecture_sample.splash

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.rahulsengupta.abstractor.core.retrofit.RetrofitResult
import me.rahulsengupta.abstractor.repository.IMainActivityRepository
import me.rahulsengupta.architecture_sample.core.coroutine.ScopedViewModel
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SplashFragmentAvm : ScopedViewModel() {
    //private val repo: IMainActivityRepository

    private val _finish: MutableLiveData<Unit> = MutableLiveData()
    val finish
        get() = _finish

    fun setup() {
        coroutineScope.launch {
            delay(TimeUnit.SECONDS.toMillis(1))
            finish.postValue(Unit)
//            repo.getPhotos().run {
//                Timber.d(toString())
//                when(this) {
//                    is RetrofitResult.SuccessfulResult -> {
//                        val firstPhoto = body.first()
//                        repo.savePhoto(firstPhoto)
//                    }
//                }
//            }
//
//            val dbResult = repo.getPhotosFromDb()
//            Timber.d(dbResult.toString())
        }
    }
}