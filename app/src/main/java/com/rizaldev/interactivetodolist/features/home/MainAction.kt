package com.rizaldev.interactivetodolist.features.home

import com.rizaldev.interactivetodolist.common.ViewAction

sealed class MainAction : ViewAction {
    object AllTodos : MainAction()
}