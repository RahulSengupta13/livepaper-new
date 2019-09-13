package me.rahulsengupta.architecture_sample.main

import kotlinx.coroutines.launch
import me.rahulsengupta.abstractor.repository.PhotoNetwork
import me.rahulsengupta.architecture_sample.core.coroutine.ScopedViewModel

class MainActivityAvm(private val network: PhotoNetwork) : ScopedViewModel() {

    fun setup() {
        coroutineScope.launch { network.getPhotos() }
    }
}