package com.rizaldev.interactivetodolist.common.base

import com.rizaldev.interactivetodolist.features.home.ui.HomeState

interface IReducer<STATE, T : Any> {
    fun reduce(baseResult: BaseResult<T>, state: HomeState?): STATE
}