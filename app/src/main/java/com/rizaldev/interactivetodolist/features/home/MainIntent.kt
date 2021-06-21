package com.rizaldev.interactivetodolist.features.home

import com.rizaldev.interactivetodolist.common.ViewIntent

sealed class MainIntent : ViewIntent {
    object LoadAllTodos : MainIntent()
}