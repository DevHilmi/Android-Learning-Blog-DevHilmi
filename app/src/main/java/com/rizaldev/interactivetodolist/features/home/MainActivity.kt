package com.rizaldev.interactivetodolist.features.home

import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.rizaldev.interactivetodolist.common.base.BaseActivity
import com.rizaldev.interactivetodolist.databinding.ActivityMainBinding
import com.rizaldev.interactivetodolist.features.home.ui.MainAction
import com.rizaldev.interactivetodolist.features.home.ui.MainIntent
import com.rizaldev.interactivetodolist.features.home.ui.MainState
import com.rizaldev.interactivetodolist.features.home.ui.MainViewModel

class MainActivity :
    BaseActivity<MainIntent, MainAction, MainState, MainViewModel, ActivityMainBinding>(
        MainViewModel::class.java
    ) {

    override fun getLayoutViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun getViewModelImp(): MainViewModel {
        val viewModel: MainViewModel by viewModels()
        return viewModel
    }

    override fun initUi() {
    }

    override fun initData() {
        dispatchIntent(MainIntent.LoadAllTodos)
    }

    override fun initEvent() {

    }

    override fun render(state: MainState) {
        when (state) {
            is MainState.Loading -> {

            }

            is MainState.ResultAllTodo -> {

            }

            is MainState.Exception -> {

            }
        }
    }


}