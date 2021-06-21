package com.rizaldev.interactivetodolist.features.home

import com.rizaldev.interactivetodolist.common.ViewState

sealed class MainState : ViewState {
    object Loading : MainState()
    data class ResultAllTodo(val data : List<String>): MainState()
    data class Exception(val errorMessage: String) : MainState()
}