package me.rahulsengupta.abstractor.core.retrofit

import okhttp3.Headers
import retrofit2.Response
import java.io.Serializable

sealed class NetworkResponse<out T> : Serializable {

    data class ErrorResult<out T>(
        val message: String,
        val response: Response<*>? = null
    ) : NetworkResponse<T>()

    data class SuccessfulResult<out T>(
        val body: T,
        val headers: Headers
    ) : NetworkResponse<T>()

}