package com.rizaldev.interactivetodolist.features.home.ui


fun List<String>.reduce(): MainState {
    return MainState.ResultAllTodo(this)
}