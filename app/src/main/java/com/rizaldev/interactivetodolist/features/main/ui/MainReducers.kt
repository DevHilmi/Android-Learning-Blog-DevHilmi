package com.rizaldev.interactivetodolist.features.main.ui


fun List<String>.reduce(): MainState {
    return MainState.ResultAllTodo(this)
}