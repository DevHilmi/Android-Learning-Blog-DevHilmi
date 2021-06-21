package com.rizaldev.interactivetodolist.common

interface IReducer<STATE, T : Any> {
    fun reduce(result: Result<T>, state: STATE): STATE
}