package me.rahulsengupta.abstractor.core.retrofit

import retrofit2.Call
import retrofit2.Response

fun <T> Call<T>.getResult(defaultErrorMessage: String = "Error"): NetworkResponse<T> {
    return try {
        val response = execute()
        if (isSuccessful(response.code())) {
            val body = response.body()
            val headers = response.headers()
            when {
                body != null -> NetworkResponse.SuccessfulResult(body, headers)
                else -> toErrorResult(defaultErrorMessage, response)
            }
        } else {
            val errorString = response.errorBody()?.string()
            toErrorResult(errorString ?: defaultErrorMessage, response)
        }
    } catch (e: Exception) {
        toErrorResult(defaultErrorMessage, null)
    }
}

private fun isSuccessful(code: Int): Boolean {
    return code in 200..299
}

private fun <R> toErrorResult(
    defaultErrorMessage: String = "",
    response: Response<*>?
): NetworkResponse.ErrorResult<R> {
    return NetworkResponse.ErrorResult(defaultErrorMessage, response)
}