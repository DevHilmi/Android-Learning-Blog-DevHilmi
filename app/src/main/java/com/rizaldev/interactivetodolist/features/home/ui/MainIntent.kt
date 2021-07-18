package com.rizaldev.interactivetodolist.features.home.ui

import com.rizaldev.interactivetodolist.common.base.ViewIntent

sealed class MainIntent : ViewIntent {
    object LoadAllTodos : MainIntent()
}