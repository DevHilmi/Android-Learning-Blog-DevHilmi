package com.rizaldev.interactivetodolist.features.home.ui

import androidx.fragment.app.viewModels
import com.rizaldev.interactivetodolist.common.base.BaseFragment
import com.rizaldev.interactivetodolist.databinding.FragmentHomeBinding

class HomeFragment :
    BaseFragment<HomeIntent, HomeAction, HomeState, HomeViewModel, FragmentHomeBinding>(
        HomeViewModel::class.java
    ) {

    override fun getLayoutViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun getViewModelImp(): HomeViewModel {
        val viewModel by viewModels<HomeViewModel>()
        return viewModel
    }

    override fun initUi() {

    }

    override fun initData() {

    }

    override fun initEvent() {
    }

    override fun render(state: HomeState) {
    }
}