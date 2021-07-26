package com.rizaldev.interactivetodolist.features.settings.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rizaldev.interactivetodolist.common.base.BaseFragment
import com.rizaldev.interactivetodolist.databinding.FragmentSettingsBinding

class SettingsFragment :
    BaseFragment<SettingsIntent, SettingsAction, SettingsState, SettingsViewModel, FragmentSettingsBinding>(
        SettingsViewModel::class.java
    ) {

    override fun getViewModelImp(): SettingsViewModel {
        val viewModel by viewModels<SettingsViewModel>()
        return viewModel
    }

    override fun initUi() {
    }

    override fun initData() {
    }

    override fun initEvent() {
    }

    override fun render(state: SettingsState) {
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingsBinding
        get() = FragmentSettingsBinding::inflate
}