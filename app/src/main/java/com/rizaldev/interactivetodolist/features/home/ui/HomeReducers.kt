package com.rizaldev.interactivetodolist.features.home.ui

import com.rizaldev.interactivetodolist.common.base.BaseResult
import com.rizaldev.interactivetodolist.common.base.IReducer
import com.rizaldev.interactivetodolist.features.home.ui.model.ContentModel

class HomeReducers : IReducer<HomeState, List<ContentModel>> {

    override fun reduce(
        baseResult: BaseResult<List<ContentModel>>,
        state: HomeState?
    ): HomeState {
        return when (baseResult) {
            is BaseResult.Success -> HomeState.ContentData(baseResult.data)
            is BaseResult.Error -> HomeState.Exception(baseResult.exception.message.toString())
            is BaseResult.Loading -> HomeState.Loading
        }
    }
}