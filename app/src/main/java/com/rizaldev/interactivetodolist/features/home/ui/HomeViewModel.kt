package com.rizaldev.interactivetodolist.features.home.ui

import androidx.lifecycle.viewModelScope
import com.rizaldev.interactivetodolist.common.base.BaseViewModel
import com.rizaldev.interactivetodolist.features.home.domain.GetHomeContent

class HomeViewModel : BaseViewModel<HomeIntent, HomeAction, HomeState>() {

    private val getHomeContent = GetHomeContent()
    private val homeReducers = HomeReducers()

    override fun intentToAction(intent: HomeIntent): HomeAction {
        return when (intent) {
            is HomeIntent.LoadHomeContent -> HomeAction.homeContent
        }
    }

    override fun handleAction(action: HomeAction) {
        launchOnUI {
            when (action) {
                is HomeAction.homeContent -> {
                    homeContentAction()
                }
            }
        }
    }

    private fun homeContentAction() {
        mState.postValue(HomeState.Loading)
        getHomeContent.invoke(
            GetHomeContent.NoParams(),
            viewModelScope
        ) {
            mState.postValue(homeReducers.reduce(it, state.value))
        }
    }
}