package com.rizaldev.interactivetodolist.features.home.ui

import com.rizaldev.interactivetodolist.common.base.BaseViewModel

class HomeViewModel : BaseViewModel<HomeIntent, HomeAction, HomeState>() {

    override fun intentToAction(intent: HomeIntent): HomeAction {
        return HomeAction()
    }

    override fun handleAction(action: HomeAction) {

    }
}