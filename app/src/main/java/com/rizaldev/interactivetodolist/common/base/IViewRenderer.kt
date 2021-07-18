package com.rizaldev.interactivetodolist.common.base

interface IViewRenderer<STATE> {
    fun render(state: STATE)
}