package com.rizaldev.interactivetodolist.common.base

interface IReducer<STATE, T : Any> {
    fun reduce(result: Result<T>, state: STATE): STATE
}