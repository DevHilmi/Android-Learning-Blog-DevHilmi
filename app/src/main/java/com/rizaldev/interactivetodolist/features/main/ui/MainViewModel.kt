package com.rizaldev.interactivetodolist.features.main.ui

import com.rizaldev.interactivetodolist.common.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel<MainIntent, MainAction, MainState>() {
    override fun intentToAction(intent: MainIntent): MainAction {
        return when (intent) {
            is MainIntent.LoadAllTodos -> MainAction.AllTodos
        }
    }

    override fun handleAction(action: MainAction) {
        launchOnUI {
            when (action) {
                is MainAction.AllTodos -> {
                    val resultMock = listOf("123", "456")
                    mState.postValue(resultMock.reduce())
                }
            }
        }
    }

}