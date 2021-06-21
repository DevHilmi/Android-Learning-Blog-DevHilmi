package com.rizaldev.interactivetodolist.common

import androidx.lifecycle.LiveData

interface IModel<STATE, INTENT> {

    val state: LiveData<STATE>

    fun dispatchIntent(intent: INTENT)
}