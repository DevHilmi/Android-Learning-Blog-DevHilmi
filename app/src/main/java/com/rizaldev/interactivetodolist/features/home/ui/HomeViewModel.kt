package com.rizaldev.interactivetodolist.features.home.ui

import androidx.lifecycle.viewModelScope
import com.rizaldev.interactivetodolist.common.base.BaseResult
import com.rizaldev.interactivetodolist.common.base.BaseViewModel
import com.rizaldev.interactivetodolist.features.home.domain.GetHomeContent
import com.rizaldev.interactivetodolist.features.home.ui.model.toListContentModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeContent: GetHomeContent,
    private val homeReducers: HomeReducers
) : BaseViewModel<HomeIntent, HomeAction, HomeState>() {

    override fun intentToAction(intent: HomeIntent): HomeAction {
        return when (intent) {
            is HomeIntent.LoadHomeContent -> HomeAction.HomeContent
        }
    }

    override fun handleAction(action: HomeAction) {
        launchOnUI {
            when (action) {
                is HomeAction.HomeContent -> {
                    homeContentAction()
                }
            }
        }
    }

    private fun homeContentAction() {
        mState.postValue(HomeState.Loading)
        getHomeContent.invoke(
            Unit,
            viewModelScope
        ) {
            mState.postValue(
                homeReducers.reduce(
                    BaseResult.Success(it.toListContentModel()),
                    state.value
                )
            )
        }
    }
}