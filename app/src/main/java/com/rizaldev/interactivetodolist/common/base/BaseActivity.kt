package com.rizaldev.interactivetodolist.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.rizaldev.interactivetodolist.features.home.ui.MainViewModel

abstract class BaseActivity<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState,
        VM : BaseViewModel<INTENT, ACTION, STATE>, T : ViewBinding>(
    private val modelClass: Class<VM>
) : AppCompatActivity(), IViewRenderer<STATE> {

    private lateinit var viewState: STATE

    val mState get() = viewState

    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getLayoutViewBinding()
        setContentView(binding.root)
        initUi()
        getViewModelImp().state.observe(this, {
            viewState = it
            render(it)
        })
        initData()
        initEvent()
    }

    abstract fun getLayoutViewBinding(): T
    abstract fun getViewModelImp(): VM
    abstract fun initUi()
    abstract fun initData()
    abstract fun initEvent()

    fun dispatchIntent(intent: INTENT) {
        getViewModelImp().dispatchIntent(intent)
    }

}