package com.rizaldev.interactivetodolist.features.main.ui

import com.rizaldev.interactivetodolist.common.base.ViewState

sealed class MainState : ViewState {
    object Loading : MainState()
    data class Content(val content : String) : MainState()
    data class Exception(val errorMessage: String) : MainState()
}