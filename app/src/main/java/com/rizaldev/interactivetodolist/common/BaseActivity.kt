package com.rizaldev.interactivetodolist.common

import android.os.Bundle
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState,
        VM : BaseViewModel<INTENT, ACTION, STATE>, T : ViewBinding>(
    private val modelClass: Class<VM>
) : RootBaseActivity(), IViewRenderer<STATE> {

    private lateinit var viewState: STATE

    val mState get() = viewState

    protected lateinit var binding: T

    private val viewModel: VM by lazy {
        viewModelProvider(
            this.viewModelFactory,
            modelClass.kotlin
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getLayoutViewBinding()
        setContentView(binding.root)
        initUi()
        viewModel.state.observe(this, {
            viewState = it
            render(it)
        })
        initData()
        initEvent()
    }

    abstract fun getLayoutViewBinding(): T
    abstract fun initUi()
    abstract fun initData()
    abstract fun initEvent()

    fun dispatchIntent(intent: INTENT) {
        viewModel.dispatchIntent(intent)
    }

}