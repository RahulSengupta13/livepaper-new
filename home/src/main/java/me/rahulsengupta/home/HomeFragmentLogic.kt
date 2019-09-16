package me.rahulsengupta.home

import me.rahulsengupta.abstractor.core.retrofit.NetworkResponse
import me.rahulsengupta.abstractor.repository.IHomeFragmentRepository
import me.rahulsengupta.home.model.HomeFragmentViewModel
import timber.log.Timber

class HomeFragmentLogic(private val repo: IHomeFragmentRepository, private val listener: Listener) {

    interface Listener {
        fun present(viewModel: HomeFragmentViewModel)
    }

    fun setup() {
        repo.getPhotos().run {
            when (this) {
                is NetworkResponse.SuccessfulResult -> {
                    val firstPhoto = body.first()
                    repo.savePhoto(firstPhoto)
                    listener.present(HomeFragmentViewModel(body))
                }
            }
        }

        val dbResult = repo.getPhotosFromDb()
        Timber.d(dbResult.toString())
    }
}