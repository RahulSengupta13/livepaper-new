package me.rahulsengupta.architecture_sample.main

import kotlinx.coroutines.launch
import me.rahulsengupta.abstractor.repository.ITypiCodeRepository
import me.rahulsengupta.architecture_sample.core.coroutine.ScopedViewModel
import timber.log.Timber

class MainActivityAvm(private val repo: ITypiCodeRepository) : ScopedViewModel() {

    fun setup() {
        coroutineScope.launch {
            val result = repo.getPhotos()
            Timber.d(result.toString())
        }
    }
}