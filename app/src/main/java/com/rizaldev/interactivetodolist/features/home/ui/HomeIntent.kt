package com.rizaldev.interactivetodolist.features.home.ui

import com.rizaldev.interactivetodolist.common.base.ViewIntent

sealed class HomeIntent : ViewIntent {
    object LoadHomeContent : HomeIntent()
}