package com.rizaldev.interactivetodolist.common

interface IViewRenderer<STATE> {
    fun render(state: STATE)
}