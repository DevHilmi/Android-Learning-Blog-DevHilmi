package com.rizaldev.interactivetodolist.features.main.ui

import com.rizaldev.interactivetodolist.common.base.BaseViewModel
import java.lang.UnsupportedOperationException
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel<MainIntent, MainAction, MainState>() {
    override fun intentToAction(intent: MainIntent): MainAction {
        throw UnsupportedOperationException()
    }

    override fun handleAction(action: MainAction) {
        launchOnUI {

        }
    }

}