package me.rahulsengupta.architecture_sample.core.coroutine

import android.content.Context
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

open class BaseCoroutine(private val context: Context) : CoroutineScope {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->

    }

    override val coroutineContext: CoroutineContext
        get() = coroutineExceptionHandler

}