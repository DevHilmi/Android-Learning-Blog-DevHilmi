package com.rizaldev.interactivetodolist.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState,
        VM : BaseViewModel<INTENT, ACTION, STATE>, T : ViewBinding>(
    private val modelClass: Class<VM>
) : Fragment(), IViewRenderer<STATE> {

    private lateinit var viewState: STATE

    val mState get() = viewState

    protected lateinit var binding: T


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        binding = getLayoutViewBinding()
        initUi()
        getViewModelImp().state.observe(viewLifecycleOwner, {
            viewState = it
            render(it)
        })
        initData()
        initEvent()
        return getLayoutViewBinding().root
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