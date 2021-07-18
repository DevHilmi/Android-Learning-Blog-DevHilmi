package com.rizaldev.interactivetodolist.features.main.ui

import com.rizaldev.interactivetodolist.common.base.ViewAction

sealed class MainAction : ViewAction {
    object AllTodos : MainAction()
}