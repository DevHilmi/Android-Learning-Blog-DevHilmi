package com.rizaldev.interactivetodolist.features.settings.ui

import com.rizaldev.interactivetodolist.common.base.BaseViewModel

class SettingsViewModel : BaseViewModel<SettingsIntent, SettingsAction, SettingsState>() {

    override fun intentToAction(intent: SettingsIntent): SettingsAction {
        return SettingsAction()
    }

    override fun handleAction(action: SettingsAction) {
    }
}