package com.rizaldev.interactivetodolist.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


abstract class BaseViewModel<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState> :
    ViewModel(), IModel<STATE, INTENT> {

    protected val mState = MutableLiveData<STATE>()
    override val state: LiveData<STATE>
        get() {
            return mState
        }

    fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }

    final override fun dispatchIntent(intent: INTENT) {
        handleAction(intentToAction(intent))
    }

    abstract fun intentToAction(intent: INTENT): ACTION
    abstract fun handleAction(action: ACTION)
}