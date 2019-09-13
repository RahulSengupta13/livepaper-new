package me.rahulsengupta.architecture_sample.main

import kotlinx.coroutines.launch
import me.rahulsengupta.abstractor.repository.PhotoApi
import me.rahulsengupta.architecture_sample.core.coroutine.ScopedViewModel

class MainActivityAvm(private val api: PhotoApi) : ScopedViewModel() {

    fun setup() {
        coroutineScope.launch { api.getPhotos() }
    }
}