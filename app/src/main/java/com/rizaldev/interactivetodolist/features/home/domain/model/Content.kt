package com.rizaldev.interactivetodolist.features.home.domain.model

data class Content(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val markdownUrl: String,
    val type: String
)
