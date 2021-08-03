package com.rizaldev.interactivetodolist.common.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseActivity<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState,
        VM : BaseViewModel<INTENT, ACTION, STATE>, VB : ViewBinding>(
    private val modelClass: Class<VM>
) : AppCompatActivity(), IViewRenderer<STATE> {

    private lateinit var viewState: STATE

    val mState get() = viewState

    private var _binding: ViewBinding? = null

    abstract val bindingInflater: (LayoutInflater) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
        initUi()
        getViewModelImp().state.observe(this, {
            viewState = it
            render(it)
        })
        initData()
        initEvent()
    }

    abstract fun getViewModelImp(): VM
    abstract fun initUi()
    abstract fun initData()
    abstract fun initEvent()

    fun dispatchIntent(intent: INTENT) {
        getViewModelImp().dispatchIntent(intent)
    }

}