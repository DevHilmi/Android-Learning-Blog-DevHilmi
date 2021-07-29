package com.rizaldev.interactivetodolist.common.base

import java.lang.Exception

sealed class BaseResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : BaseResult<T>()
    data class Error(val exception: Exception) : BaseResult<Nothing>()
    object Loading : BaseResult<Nothing>()
}