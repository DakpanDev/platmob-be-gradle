package com.dakpandev.platmobbegradle.domain.generic

sealed class ResponseBody {

    data class Success<T>(
        val data: T,
    ) : ResponseBody()

    data class Error(
        val message: String,
    ) : ResponseBody()
}
