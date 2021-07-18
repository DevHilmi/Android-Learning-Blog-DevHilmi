package com.rizaldev.interactivetodolist.features.splash.ui

import com.rizaldev.interactivetodolist.common.base.BaseViewModel

class SplashViewModel : BaseViewModel<SplashIntent, SplashAction, SplashState>() {

    override fun intentToAction(intent: SplashIntent): SplashAction {
        return SplashAction()
    }

    override fun handleAction(action: SplashAction) {

    }
}