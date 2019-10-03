package me.rahulsengupta.home

import me.rahulsengupta.home.model.HomeFragmentViewModel
import me.rahulsengupta.abstractor.core.retrofit.NetworkResponse
import me.rahulsengupta.abstractor.repository.IHomeFragmentRepository
import timber.log.Timber

class HomeFragmentLogic(private val repo: IHomeFragmentRepository, private val listener: Listener) {

    interface Listener {
        fun present(viewModel: HomeFragmentViewModel)
    }

    fun setup() {
        repo.getCollections(1, 10).run {
            when (this) {
                is NetworkResponse.SuccessfulResult -> {
                    listener.present(HomeFragmentViewModel(body))
                }
            }
        }
    }
}