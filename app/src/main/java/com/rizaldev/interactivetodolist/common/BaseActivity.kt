package com.rizaldev.interactivetodolist.common

import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState, VM : BaseViewModel<INTENT, ACTION, STATE>>(
    private val modelClass: Class<VM>
) : RootBaseActivity(), IViewRenderer<STATE> {

    private lateinit var viewState: STATE

    val mState get() = viewState

    private lateinit var binding: ViewBinding

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

    abstract fun getLayoutViewBinding(): ViewBinding
    abstract fun initUi()
    abstract fun initData()
    abstract fun initEvent()

    fun dispatchIntent(intent: INTENT) {
        viewModel.dispatchIntent(intent)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getViewBinding(): T {
        return binding as T
    }
}