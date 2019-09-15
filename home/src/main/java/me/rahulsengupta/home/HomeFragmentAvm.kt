package me.rahulsengupta.home

import kotlinx.coroutines.launch
import me.rahulsengupta.abstractor.core.retrofit.NetworkResponse
import me.rahulsengupta.abstractor.repository.IHomeFragmentRepository
import me.rahulsengupta.shared.coroutine.ScopedViewModel
import timber.log.Timber

class HomeFragmentAvm(private val repo: IHomeFragmentRepository) : ScopedViewModel() {

    fun setup() {
        coroutineScope.launch {
            repo.getPhotos().run {
                Timber.d(toString())
                when (this) {
                    is NetworkResponse.SuccessfulResult -> {
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