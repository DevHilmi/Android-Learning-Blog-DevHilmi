package com.rizaldev.interactivetodolist.features.home


fun List<String>.reduce(): MainState {
    return MainState.ResultAllTodo(this)
}