package me.rahulsengupta.architecture_sample.main

import kotlinx.coroutines.launch
import me.rahulsengupta.abstractor.core.retrofit.RetrofitResult
import me.rahulsengupta.abstractor.repository.IMainActivityRepository
import me.rahulsengupta.architecture_sample.core.coroutine.ScopedViewModel
import timber.log.Timber

class MainActivityAvm(private val repo: IMainActivityRepository) : ScopedViewModel() {

    fun setup() {
        coroutineScope.launch {

            repo.getPhotos().run {
                Timber.d(toString())
                when(this) {
                    is RetrofitResult.SuccessfulResult -> {
                        val firstPhoto = body.first()
                        repo.savePhoto(firstPhoto)
                    }
                }
            }

            val dbResult = repo.getPhotosFromDb()
            Timber.d(dbResult.toString())
        }
    }
}