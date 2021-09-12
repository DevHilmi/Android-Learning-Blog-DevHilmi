package com.rizaldev.interactivetodolist.features.home.ui

import com.rizaldev.interactivetodolist.common.base.ViewState
import com.rizaldev.interactivetodolist.features.home.ui.model.ContentModel

sealed class HomeState : ViewState {
    object Loading : HomeState()
    data class ContentData(val data: List<ContentModel>) : HomeState()
    data class Exception(val errorMessage: String) : HomeState()
}