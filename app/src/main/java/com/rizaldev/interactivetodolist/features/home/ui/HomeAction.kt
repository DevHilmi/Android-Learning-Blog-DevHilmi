package com.rizaldev.interactivetodolist.features.home.ui

import com.rizaldev.interactivetodolist.common.base.ViewAction

sealed class HomeAction : ViewAction {
    object HomeContent : HomeAction()
}