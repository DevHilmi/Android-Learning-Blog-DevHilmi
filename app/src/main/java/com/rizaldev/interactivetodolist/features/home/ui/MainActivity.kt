package com.rizaldev.interactivetodolist.features.home.ui

import com.rizaldev.interactivetodolist.common.BaseActivity
import com.rizaldev.interactivetodolist.databinding.ActivityMainBinding
import com.rizaldev.interactivetodolist.features.home.MainAction
import com.rizaldev.interactivetodolist.features.home.MainIntent
import com.rizaldev.interactivetodolist.features.home.MainState
import com.rizaldev.interactivetodolist.features.home.MainViewModel

class MainActivity :
    BaseActivity<MainIntent, MainAction, MainState, MainViewModel, ActivityMainBinding>(
        MainViewModel::class.java
    ) {

    override fun getLayoutViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
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
                binding.textTitle.text = state.data[0]
            }

            is MainState.Exception -> {

            }
        }
    }

}