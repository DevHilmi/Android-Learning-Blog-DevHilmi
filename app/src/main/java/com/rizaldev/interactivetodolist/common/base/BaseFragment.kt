package com.rizaldev.interactivetodolist.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState,
        VM : BaseViewModel<INTENT, ACTION, STATE>, VB : ViewBinding>(
    private val modelClass: Class<VM>
) : Fragment(), IViewRenderer<STATE> {

    private lateinit var viewState: STATE

    val mState get() = viewState

    private var _binding: ViewBinding? = null

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUi()
        getViewModelImp().state.observe(viewLifecycleOwner, {
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